/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package griffon.plugins.dialogs;

import griffon.javafx.JavaFXGriffonApplication;
import griffon.javafx.WindowManager;
import groovy.util.FactoryBuilderSupport;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.codehaus.griffon.runtime.core.AbstractGriffonController;

import java.util.Collection;

/**
 * @author Andres Almiray
 */
public abstract class AbstractDialogController extends AbstractGriffonController {
    private AbstractDialogModel model;
    private FactoryBuilderSupport builder;
    private static final String CONTENT = "content";

    protected Stage dialog;

    public void setModel(AbstractDialogModel model) {
        this.model = model;
    }

    public void setBuilder(FactoryBuilderSupport builder) {
        this.builder = builder;
    }

    public AbstractDialogModel getModel() {
        return model;
    }

    public FactoryBuilderSupport getBuilder() {
        return builder;
    }

    public void show() {
        show((Window) null);
    }

    public void show(final Window owner) {
        execInsideUISync(new Runnable() {
            public void run() {
                Window window = owner;
                if (window == null) {
                    Collection<Window> windows = windowManager().getWindows();
                    for (Window w : windows) {
                        if (w.isFocused()) {
                            window = w;
                            break;
                        }
                    }
                }

                if (dialog == null || dialog.getOwner() != window) {
                    if (dialog != null) windowManager().hide(dialog);
                    dialog = createDialog(window);
                }

                windowManager().show(dialog);
            }
        });
    }

    private WindowManager windowManager() {
        return ((JavaFXGriffonApplication) getApp()).getWindowManager();
    }

    public void hide() {
        execInsideUISync(new Runnable() {
            public void run() {
                windowManager().hide(dialog);
                dialog = null;
            }
        });
    }

    protected Stage createDialog(Window owner) {
        dialog = new Stage();
        if (null != owner) dialog.initOwner(owner);
        dialog.initModality(model.getModality());
        dialog.initStyle(model.getStageStyle());
        dialog.setWidth(model.getWidth());
        dialog.setHeight(model.getHeight());
        dialog.titleProperty().bind(model.titleProperty());
        dialog.resizableProperty().bind(model.resizableProperty());
        dialog.setScene((Scene) builder.getVariable(CONTENT));
        dialog.sizeToScene();
        return dialog;
    }
}

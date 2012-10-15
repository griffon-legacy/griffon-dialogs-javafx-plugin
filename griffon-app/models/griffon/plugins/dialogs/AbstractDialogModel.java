/*
 * Copyright 2012 the original author or authors.
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

import javafx.beans.property.*;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import org.codehaus.griffon.runtime.core.AbstractGriffonModel;

import java.util.Map;

import static griffon.util.GriffonNameUtils.capitalize;
import static griffon.util.GriffonNameUtils.isBlank;

/**
 * @author Andres Almiray
 */
public abstract class AbstractDialogModel extends AbstractGriffonModel {
    private StringProperty title;
    private DoubleProperty width;
    private DoubleProperty height;
    private BooleanProperty resizable;
    private Modality modality = Modality.APPLICATION_MODAL;
    private StageStyle stageStyle = StageStyle.UTILITY;

    public final StringProperty titleProperty() {
        if (title == null) {
            title = new SimpleStringProperty(this, "title", "");
        }
        return title;
    }

    public void setTitle(String title) {
        titleProperty().set(title);
    }

    public String getTitle() {
        return titleProperty().get();
    }

    public final DoubleProperty widthProperty() {
        if (width == null) {
            width = new SimpleDoubleProperty(this, "width", 100);
        }
        return width;
    }

    public void setWidth(double width) {
        widthProperty().set(width);
    }

    public double getWidth() {
        return widthProperty().get();
    }

    public final DoubleProperty heightProperty() {
        if (height == null) {
            height = new SimpleDoubleProperty(this, "height", 100);
        }
        return height;
    }

    public void setHeight(double height) {
        heightProperty().set(height);
    }

    public double getHeight() {
        return heightProperty().get();
    }

    public final BooleanProperty resizableProperty() {
        if (resizable == null) {
            resizable = new SimpleBooleanProperty(this, "resizable", false);
        }
        return resizable;
    }

    public void setResizable(boolean resizable) {
        resizableProperty().set(resizable);
    }

    public boolean getResizable() {
        return resizableProperty().get();
    }

    public boolean isResizable() {
        return resizableProperty().get();
    }

    public void setModality(String modality) {
        if (!isBlank(modality)) setModality(Modality.valueOf(modality.toUpperCase()));
    }

    public final void setModality(Modality value) {
        this.modality = value;
    }

    public final Modality getModality() {
        return modality;
    }

    public void setStageStyle(String modality) {
        if (!isBlank(modality)) setStageStyle(StageStyle.valueOf(modality.toUpperCase()));
    }

    public final void setStageStyle(StageStyle value) {
        this.stageStyle = value;
    }

    public final StageStyle getStageStyle() {
        return stageStyle;
    }

    protected abstract String getDialogKey();

    protected abstract String getDialogTitle();

    public void mvcGroupInit(Map<String, Object> args) {
        setTitle(capitalize(getApp().getMessage("application.dialog." + getDialogKey() + ".title", getDialogTitle())));
    }
}

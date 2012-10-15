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

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.codehaus.griffon.runtime.core.AbstractGriffonView;

import java.util.Map;

/**
 * @author Andres Almiray
 */
public abstract class AbstractDialogView extends AbstractGriffonView {
    // these will be injected by Griffon
    private AbstractDialogController controller;
    private AbstractDialogModel model;

    public void setController(AbstractDialogController controller) {
        this.controller = controller;
    }

    public void setModel(AbstractDialogModel model) {
        this.model = model;
    }

    // build the UI
    protected Scene buildContent() {
        Scene scene = new Scene(new Group());
        scene.setFill(Color.BLACK);

        Text javaText = new Text();
        javaText.setText("Dialog");
        javaText.setFont(new Font("Sanserif", 80));
        javaText.setFill(LinearGradientBuilder.create().endX(0)
            .stops(new Stop(0, Color.ORANGE), new Stop(1, Color.CHOCOLATE)).build());

        Text fxText = new Text();
        fxText.setText("FX");
        fxText.setFont(new Font("Sanserif", 80));
        fxText.setFill(LinearGradientBuilder.create().endX(0)
            .stops(new Stop(0, Color.CYAN), new Stop(1, Color.DODGERBLUE)).build());
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.DODGERBLUE);
        dropShadow.setRadius(25);
        dropShadow.setSpread(0.25);
        fxText.setEffect(dropShadow);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(javaText, fxText);
        hbox.setPadding(new Insets(80, 80, 80, 80));
        ((Group) scene.getRoot()).getChildren().addAll(hbox);

        return scene;
    }

    @Override
    public void mvcGroupInit(final Map<String, Object> args) {
        execInsideUISync(new Runnable() {
            public void run() {
                getBuilder().setVariable("content", buildContent());
            }
        });
    }
}

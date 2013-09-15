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

/**
 * @author Andres Almiray
 */
class DialogsJavafxGriffonPlugin {
    // the plugin version
    String version = '0.2.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.4.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [javafx: '0.10.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['javafx']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-dialogs-javafx-plugin'

    List authors = [
        [
            id: 'aalmiray',
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Common JavaFX dialogs'
    String description = '''
The goal of this plugin is to provide a set of reusable dialogs for JavaFX based applications.

Usage
-----

### Plain Dialog
JavaFX 2.2 does not include a `Dialog` class, however such behavior can be modeled using an MVC group. Invoke the following
command to create a dialog ready MVC group

    griffon create-mvc --group=Dialog <dialog_name>

Where `<dialog_name>` stands for the name of the group. This will create dialog components based on the default templates.
Making use of this new group is as easy as invoking

    withMVCGroup('<dialog_name>') { m, v, c -> c.show() }

if the dialog's modality is set to `Modality.APPLICATION_MODAL` (default) or `Modality.WINDOW_MODAL`. Use this version if the modality
is set to `Modality.NONE`

    def (m, v, c) = createMVCGroup('<dialog_name>')
    c.show()

'''
}

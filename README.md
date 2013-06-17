
Common JavaFX dialogs
---------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/dialogs-javafx](http://artifacts.griffon-framework.org/plugin/dialogs-javafx)


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



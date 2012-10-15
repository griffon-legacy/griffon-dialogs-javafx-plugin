@artifact.package@import griffon.plugins.dialogs.AbstractDialogModel

class @artifact.name@ extends AbstractDialogModel {
    protected String getDialogKey() { '@artifact.name.plain@' }

    protected String getDialogTitle() { '@artifact.name@' }

    void mvcGroupInit(Map args) {
        super.mvcGroupInit(args)
        width = 500
        height = 300
    }
}

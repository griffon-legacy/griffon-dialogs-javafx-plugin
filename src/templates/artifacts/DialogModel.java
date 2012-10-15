@artifact.package@import griffon.plugins.dialogs.AbstractDialogModel;
import java.util.Map;

public class @artifact.name@ extends AbstractDialogModel {
    protected String getDialogKey() { return "@artifact.name.plain@"; }

    protected String getDialogTitle() { return "@artifact.name@"; }

    public void mvcGroupInit(Map<String, Object> args) {
        super.mvcGroupInit(args);
        setWidth(500);
        setHeight(300);
    }
}

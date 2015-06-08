package Common.interfaces;

/**
 * Created by tales on 07/06/15.
 */
public interface INode {

    public boolean isActive();
    public void active();
    public void deactive();

    public int getDoor();
    public String getIp();

    public void deleteNode();

    public void upNode();
}

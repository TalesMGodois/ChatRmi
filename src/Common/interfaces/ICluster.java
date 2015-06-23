package Common.interfaces;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Created by tales on 07/06/15.
 */
public interface ICluster extends Remote{
    public boolean testNode(INode node);

    public void sincronize();

    public void addNode(INode node);

    public void removeNode(INode node);

}

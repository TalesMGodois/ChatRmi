package Common.objects;

import Common.interfaces.INode;

/**
 * Created by tales on 07/06/15.
 */
public class Node implements INode{

    private int id;
    private int door;
    private String ip;
    private boolean activated;


    public Node(int id,int door,String ip){
        this.id = id;
        this.door = door;
        this.ip = ip;

    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean isActive() {
        return this.activated;
    }

    @Override
    public void active() {
        this.activated = true;
    }

    @Override
    public void deactive() {
        this.activated = false;
    }

    @Override
    public int getDoor() {
        return this.door;
    }

    @Override
    public String getIp() {
        return this.ip;
    }


    @Override
    public void deleteNode() {
        this.deactive();
    }

    @Override
    public void upNode() {
        this.active();
    }
}

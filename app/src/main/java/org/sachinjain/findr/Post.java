package org.sachinjain.findr;

/**
 * Created by Sachin Jain on 1/7/2018.
 */

public class Post {

    private String mName;
    private String mLocation;
    private String mItem;
    private String mReward;
    private String mDescription;
    private String mContact;

    public Post(String name, String location, String item, String reward, String description, String contact){
        mName = name;
        mLocation = location;
        mItem = item;
        mReward = reward;
        mDescription = description;
        mContact = contact;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmItem() {
        return mItem;
    }

    public void setmItem(String mItem) {
        this.mItem = mItem;
    }

    public String getmReward() {
        return mReward;
    }

    public void setmReward(String mReward) {
        this.mReward = mReward;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    @Override
    public String toString() {
        return "Post{" +
                "mName='" + mName + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mItem='" + mItem + '\'' +
                ", mReward='" + mReward + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mContact='" + mContact + '\'' +
                '}';
    }
}

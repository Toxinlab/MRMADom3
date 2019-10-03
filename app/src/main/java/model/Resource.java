package model;

public class Resource<T> {

    private T mData;
    private boolean mIsSucc;

    public Resource(T mData, boolean isSucc) {
        this.mData = mData;
        this.mIsSucc = isSucc;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data){
        mData = data;
    }

    public boolean isSucc() {
        return mIsSucc;
    }

    public void setSucc(boolean mIsSucc) {
        this.mIsSucc = mIsSucc;
    }
}

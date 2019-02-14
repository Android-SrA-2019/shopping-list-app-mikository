package ca.nbcc.shoppinglist;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String Name;
    private double Price;
    private int Count;

    public Item(Parcel in) {
        Name = in.readString();
        Price = in.readDouble();
        Count = in.readInt();
    }
    public Item(String name, double price, int count){
        Name = name;
        Price = price;
        Count = count;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    public void writeToParcel(Parcel dest, int flags) {
// Write data in any order
        dest.writeString(Name);
        dest.writeDouble(Price);
        dest.writeInt(Count);
    }

    public String toString(){
        return "Qty: " + Count + " Name: " + Name + " price: $" + Price + " Total: " + getTotal();
    }

    public String getNameAndPrice(){
        return Name + " price: $" +Price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public double getTotal(){
        return Price * Count;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getCount() {
        return Count;
    }

    public void addItems(int count) {
        Count += count;
    }

    public boolean compare(Item item){
        return item.getName().equals(this.getName());
    }
}

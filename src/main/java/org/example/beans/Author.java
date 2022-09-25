package org.example.beans;

import java.io.Serializable;

public class Author implements Serializable {
    private int id;
    private String first;
    private String last;

    public Author() {
        this.id = -1;
        this.first = null;
        this.last = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Author{id=" + getId() + ", first=" + getFirst() + ", last=" + getLast() + "}";
    }
}

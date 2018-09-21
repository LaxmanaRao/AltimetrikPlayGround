package com.example.namra.altimetrikplayground;

public class Categories
{
    private String id;

    private String clues_count;

    private String title;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getClues_count ()
    {
        return clues_count;
    }

    public void setClues_count (String clues_count)
    {
        this.clues_count = clues_count;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", clues_count = "+clues_count+", title = "+title+"]";
    }
}





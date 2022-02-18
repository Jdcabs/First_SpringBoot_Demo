package com.example.test.model;

public class ImutableSetup{

    private final String id;
    private final String name;
    private final String section;

    public ImutableSetup(String id, String name, String section){
        this.id = id;
        this.name = name;
        this.section = section;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSection(){
        return section;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((section == null) ? 0 : section.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImutableSetup other = (ImutableSetup) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (section == null) {
            if (other.section != null)
                return false;
        } else if (!section.equals(other.section))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "ImutableSetup [id=" + id + ", name=" + name + ", section=" + section + "]";
    }

    
}
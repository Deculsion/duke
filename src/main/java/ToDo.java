class ToDo extends Task {

    ToDo(String toAdd){
        super(toAdd);
    }

    public String toString() {
        return "[T]" + super.toString();
    }

}

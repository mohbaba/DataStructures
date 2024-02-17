package ProblemAndPersons;

public class Problem {
    private String name;
    private Type type;

    private boolean isSolved;

    public Problem(String name, Type type){
        this.name = name;
        this.type = type;
    }

//    public void changeStatus() {
//        isSolved = !isSolved;
//    }

    public boolean status(){
        return isSolved;
    }

    public String toString(){
        return String.format(this.name);
    }
}

package ProblemAndPersons;

import java.util.ArrayList;

public class Person {
    private ArrayList<Problem> problems = new ArrayList<>();

    public int countProblems() {
        return problems.size();
    }

    public void addProblem(String name, Type type) {
        problems.add(new Problem(name, type));
    }

    public Problem getProblem(String problemName){
        for (int problem = 0; problem < problems.size(); problem++) {
            if (problems.get(problem).toString().contains(problemName)) {
                return problems.get(problem);
            }
        }
        return null;
    }

    private void changeProblemStatus(Problem problem) {
        ;
    }
    public void solveProblem(String problemName) {
        for (int problem = 0; problem < problems.size(); problem++) {
            if (problems.get(problem).toString().contains(problemName)) {
                problems.get(problem);
            }
        }
    }

//    public ArrayList<Problem> recount() {
//        for (Problem problem : problems) {
//
//        }
//    }
}

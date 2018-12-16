package main.java;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

import static main.java.Constants.EPS;

public class ConvexHullManager {
    public ArrayList<Point> activePoints;

    public ConvexHullManager() {
        activePoints = new ArrayList<>();
    }

    public void add(Point p) {
        activePoints.add(p);
        redoHull();
    }

    private void redoHull() {
        Collections.sort(activePoints);
        int n = activePoints.size();
        Stack<Point> stk = new Stack<>();
        for (int i = 0; i < n + n; ++i) {
            var c = activePoints.get(i < n ? i : n + n - i - 1);
            if (i < n) {
                c.resetRemoveCounter();
            }

            while (stk.size() > 1) {
                var b = stk.pop();
                var a = stk.peek();
                if (isRightTurn(a, b, c)) {
                    stk.push(b);
                    break;
                } else {
                    b.remove();
                }
            }
            stk.push(c);
        }
        stk.pop().remove();
        activePoints = new ArrayList<>(stk);
    }

    private static boolean isRightTurn(Point a, Point b, Point c) {
        double cross = (a.x - b.x) * (c.y - b.y) - (a.y - b.y) * (c.x - b.x);
        double dot = (a.x - b.x) * (c.x - b.x) + (a.y - b.y) * (c.y - b.y);
        return !(cross < -EPS || cross < EPS && dot < EPS);
    }
}

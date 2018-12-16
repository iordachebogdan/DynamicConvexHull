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
            while (stk.size() > 1) {
                var b = stk.pop();
                var a = stk.peek();
                if (!isNotRightTurn(a, b, c)) {
                    stk.push(b);
                    break;
                }
            }
            stk.push(c);
        }
        stk.pop();
        activePoints = new ArrayList<>(stk);
    }

    private static boolean isNotRightTurn(Point a, Point b, Point c) {
        double cross = (a.x - b.x) * (c.y - b.y) - (a.y - b.y) * (c.x - b.x);
        double dot = (a.x - b.x) * (c.x - b.x) + (a.y - b.y) * (c.y - b.y);
        return cross < -EPS || cross < EPS && dot <= EPS;
    }
}

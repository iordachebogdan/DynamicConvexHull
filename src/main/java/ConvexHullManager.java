package main.java;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import static main.java.Constants.EPS;

public class ConvexHullManager {
    private NavigableSet<Point>[] hull;

    public ConvexHullManager() {
        hull = new NavigableSet[2];
        hull[0] = new TreeSet<>(Comparator.naturalOrder());
        hull[1] = new TreeSet<>(Comparator.reverseOrder());
    }

    public void add(Point p) {
        for (int sidx = 0; sidx < 2; ++sidx) {
            var h = hull[sidx];

            var prev = h.lower(p);
            var next = h.higher(p);
            if (isNotRightTurn(prev, p, next)) {
                p.setInactive();
                continue;
            }

            while (prev != null) {
                var pprev = h.lower(prev);
                if (!isNotRightTurn(pprev, prev, p)) {
                    break;
                }

                h.remove(prev);
                prev.setInactive();
                prev = pprev;
            }

            while (next != null) {
                var nnext = h.higher(next);
                if (!isNotRightTurn(p, next, nnext)) {
                    break;
                }

                h.remove(next);
                next.setInactive();
                next = nnext;
            }
            h.add(p);
        }
    }

    private static boolean isNotRightTurn(Point a, Point b, Point c) {
        if (a == null || c == null) {
            return false;
        }

        final double cross = (a.x - b.x) * (c.y - b.y) - (a.y - b.y) * (c.x - b.x);
        final double dot = (a.x - b.x) * (c.x - b.x) + (a.y - b.y) * (c.y - b.y);
        return (cross < -EPS || cross < EPS && dot < -EPS);
    }
};
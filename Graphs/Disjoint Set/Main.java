import java.util.*;

class DisjointSet {

    // initital data structures required
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n)
    {
        // base setup
        for(int i = 0; i <= n; i++)
        {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node)
    {
        // doing path compression while finding the ultimate parent
        if(node == parent.get(node))
        {
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v)
    {
        // find both the ultimate parent
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // if both are in same component don't do anything
        if(ulp_u == ulp_v)
        {
            return ;
        }

        // connect smaller rank to larger rank
        // first to keep it shrink
        // second is to make sure that the time taken and finding of the parents os as minimal as possible
        if(rank.get(ulp_u) < rank.get(ulp_v))
        {
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_u) > rank.get(ulp_v))
        {
            parent.set(ulp_v, ulp_u);
        }
        else // if equal rank then increase the rank of the component to which you connected the other
        {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v)
    {
        // find both the ultimate parent
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // if both are in same component don't do anything
        if(ulp_u == ulp_v)
        {
            return ;
        }

        // connect smaller size to larger size and increase the size of the component to which you connected
        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else
        {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Main {
    public static void main(String[] args) {

        // disjoint set [union by rank]
        
        // DisjointSet ds = new DisjointSet(7);

        // ds.unionByRank(1, 2);
        // ds.unionByRank(2, 3);
        // ds.unionByRank(4, 5);
        // ds.unionByRank(6, 7);
        // ds.unionByRank(5, 6);

        // if(ds.findUPar(3) == ds.findUPar(7))
        // {
        //     System.out.println("Same");
        // }
        // else
        // {
        //     System.out.println("Not Same");
        // }

        // ds.unionByRank(3, 7);

        // if(ds.findUPar(3) == ds.findUPar(7))
        // {
        //     System.out.println("Same");
        // }
        // else
        // {
        //     System.out.println("Not Same");
        // }

        // disjoint set [union by rank]

        DisjointSet ds = new DisjointSet(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if(ds.findUPar(3) == ds.findUPar(7))
        {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Not Same");
        }

        ds.unionByRank(3, 7);

        if(ds.findUPar(3) == ds.findUPar(7))
        {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Not Same");
        }
    }
}
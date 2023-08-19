class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    int N = accounts.size();
    
    // declare disjoint set data structure
    DisjointSet ds = new DisjointSet(N);
    
    // map to store the mails to node details
    HashMap<String, Integer> mapMailToNode = new HashMap<>();
    
    // iterating the accounts given
    for(int i = 0; i < N; i++)
    {
        for(int j = 1; j < accounts.get(i).size(); j++)
        {
            String mail = accounts.get(i).get(j);
            
            // if map doesnot have the mail then just simply add the mail corresponding to the index node
            if(!mapMailToNode.containsKey(mail))
            {
                mapMailToNode.put(mail, i);
            }
            else // if map have the mail then merge the index node to the existing node corresponding the mail in map
            {
                ds.unionBySize(i, mapMailToNode.get(mail));
            }
        }
    }
    
    // creating the arraylist of mails after merging
    ArrayList<String>[] mergedMail = new ArrayList[N];
    
    for(int i = 0; i < N; i++)
    {
        mergedMail[i] = new ArrayList<>();
    }
    
    // iterating hashmap
    for(Map.Entry<String, Integer> ent : mapMailToNode.entrySet())
    {
        // take the mail
        String mail = ent.getKey();
        
        // find the ultimate parent from the given value of the mail in hashmap to which the mail should be attached
        int node = ds.findUPar(ent.getValue());
        
        // attach the mail to the ultimate parent
        mergedMail[node].add(mail);
    }

    List<List<String>> ans = new ArrayList<>();
    
    for(int i = 0; i < N; i++)
    {
        
        // if it is a empty array then skip
        if(mergedMail[i].size() == 0) continue;
        
        // sort the merged mails
        Collections.sort(mergedMail[i]);
        
        // create a temporary arraylist
        List<String> temp = new ArrayList<>();
        
        // first add the name
        temp.add(accounts.get(i).get(0));
        
        // then add the mails
        for(String mail : mergedMail[i])
        {
            temp.add(mail);
        }
        
        // add temporary arraylist to the answer arraylist
        ans.add(temp);
    }
    
    return ans;
  }
}
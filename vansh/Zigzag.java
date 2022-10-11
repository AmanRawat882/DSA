static int[][] solve(TreeNode root){
    //CODE HERE 
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        List<Integer> list = new ArrayList<>();
        int len = queue.size();
        for(int i=0;i<len;i++){
            if(queue.peek().left!=null)
                queue.add(queue.peek().left);
            if(queue.peek().right!=null)
                queue.add(queue.peek().right);
            list.add(queue.poll().val);
        }
        result.add(list);
    }
    int[][] intArray = result.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
    for(int i=0;i<intArray.length;i++){
        if(i%2!=0){
            int temp;
            int start=0,end=result.get(i).size()-1;
            while (start < end)
            {
                temp = intArray[i][start];
                intArray[i][start] = intArray[i][end];
                intArray[i][end] = temp;
                start++;
                end--;
            }
        }
    }
    return intArray;
    }
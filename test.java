  public int[] constTreeParents(Tree tree) {
    List<Tree> leaves = collapsedUnary.getLeaves();
    // leaves = ['c','f', 'g', 'e']
    int size = collapsedUnary.size() - leaves.size();
    // size = 8-4 = 4
    int[] parents = new int[size];
    HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();

    int idx = leaves.size();
    // idx = 4
    int leafIdx = 0;
    for (Tree leaf : leaves) {
      // FIRST ITERATION OF FOR LOOP
      // leaf 'c' selected in first iteration
      Tree cur = leaf.parent(collapsedUnary); // go to preterminal
      // cur = 'a'
      int curIdx = leafIdx++;
      // curIdx = 0; leafIdx = 1
      boolean done = false;
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = 'x'
        if (parent == null) {
          parents[curIdx] = 0;
          break;
        }
      
        int parentIdx;
        int parentNumber = parent.nodeNumber(collapsedUnary);
        // parentNumber = 0 for 'x'
        if (!index.containsKey(parentNumber)) {
          // If condition true. Enters this subsection
          parentIdx = idx++;
          // parentIdx = 4; idx = 5
          index.put(parentNumber, parentIdx);
          // index = [0:4]
        } else {
        // doesn't enter else.
          parentIdx = index.get(parentNumber);
          done = true;
        }

        parents[curIdx] = parentIdx + 1;
        // parents = [0:5]
        cur = parent;
        // cur = 'x'
        curIdx = parentIdx;
        // curIdx = 4
        // done=False; enters while loop once more
      }
    // 2nd ITERATION OF WHILE LOOP
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = null
        if (parent == null) {
          // if condition true. Enters loop.
          parents[curIdx] = 0;
          // parents = [0:5, 4:0]
          break;
        }
    

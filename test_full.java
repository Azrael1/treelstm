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
  // FIRST ITERATION OF FOR LOOP(LEAF 'C')
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
  // 2nd ITERATION OF WHILE LOOP within 1st iteration of for loop
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = null
        if (parent == null) {
          // if condition true. Enters loop.
          parents[curIdx] = 0;
          // parents = [0:5, 4:0]
          break;
        }
  // 2nd ITERATION OF FOR LOOP (LEAF 'F')
      // leaf 'f' selected in second iteration
      Tree cur = leaf.parent(collapsedUnary); // go to preterminal
      // cur = 'd'
      int curIdx = leafIdx++;
      // curIdx = 1; leafIdx = 2
      boolean done = false;
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = 'b'
        if (parent == null) {
          // condition false
          parents[curIdx] = 0;
          break;
        }
      
        int parentIdx;
        int parentNumber = parent.nodeNumber(collapsedUnary);
        // parentNumber = 3 for 'b'
        if (!index.containsKey(parentNumber)) {
          // If condition true. Enters this subsection
          parentIdx = idx++;
          // parentIdx = 5; idx = 6
          index.put(parentNumber, parentIdx);
          // index = [0:4, 3:5]
        } else {
        // doesn't enter else.
          parentIdx = index.get(parentNumber);
          done = true;
        }

        parents[curIdx] = parentIdx + 1;
        // parents = [0:5, 1:6]
        cur = parent;
        // cur = 'b'
        curIdx = parentIdx;
        // curIdx = 5
        // done=False; enters while loop once more
      }
  // 2nd ITERATION OF WHILE LOOP within the 2nd iteration of for loop
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = 'x'
        if (parent == null) {
          // if condition false. Skips loop.
          parents[curIdx] = 0;
          break;
        }
        int parentIdx;
        int parentNumber = parent.nodeNumber(collapsedUnary);
        // parentNumber = 0 for 'x'
        if (!index.containsKey(parentNumber)) {
          // If condition false. Skips this subsection
          parentIdx = idx++;
          index.put(parentNumber, parentIdx);
        } else {
        // enters else.
        // index = [0:4, 3:5] (line number 85)
          parentIdx = index.get(parentNumber);
          // parentIdx = 4
          done = true;
        }
        // curIdx is presently = 5(line number 97)
        parents[curIdx] = parentIdx + 1;
        // parents = [0:5, 1:6, 5:5]
        cur = parent;
        // cur = 'x'
        curIdx = parentIdx;
        // curIdx = 4
      }
  // THIRD ITERATION OF FOR LOOP(LEAF 'G')
  // leaf 'g' selected in first iteration
      Tree cur = leaf.parent(collapsedUnary); // go to preterminal
      // cur = 'd'
      int curIdx = leafIdx++;
      // curIdx = 2; leafIdx = 3
      boolean done = false;
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = 'b'
        if (parent == null) {
          // if condition false. Skips loop.
          parents[curIdx] = 0;
          break;
        }
      
        int parentIdx;
        int parentNumber = parent.nodeNumber(collapsedUnary);
        // parentNumber = 3 for 'b'
        if (!index.containsKey(parentNumber)) {
          // If condition false. Skips this subsection
          parentIdx = idx++;
          index.put(parentNumber, parentIdx);
        } else {
        // enters else.
          parentIdx = index.get(parentNumber);
          // parentIdx = 5 (line number 85)
          done = true;
        }

        parents[curIdx] = parentIdx + 1;
        // parents = [0:5, 1:6, 5:5, 2:6] (line 125 + new addition)
        cur = parent;
        // cur = 'b'
        curIdx = parentIdx;
        // curIdx = 5
        // done=True; runs 4th iteration of for loop.
      }
  // FOURTH ITERATION OF FOR LOOP(LEAF 'E')
  // leaf 'e' selected in first iteration
      Tree cur = leaf.parent(collapsedUnary); // go to preterminal
      // cur = 'b'
      int curIdx = leafIdx++;
      // curIdx = 3; leafIdx = 4
      boolean done = false;
      while (!done) {
        Tree parent = cur.parent(collapsedUnary);
        // parent = 'x'
        if (parent == null) {
          // if condition false. Skips loop.
          parents[curIdx] = 0;
          break;
        }
      
        int parentIdx;
        int parentNumber = parent.nodeNumber(collapsedUnary);
        // parentNumber = 0 for 'x'
        if (!index.containsKey(parentNumber)) {
          // If condition false. Skips this subsection
          parentIdx = idx++;
          index.put(parentNumber, parentIdx);
        } else {
        // enters else.
          parentIdx = index.get(parentNumber);
          // parentIdx = 4 (line number 85 (index = [0:4, 3:5] )
          done = true;
        }

        parents[curIdx] = parentIdx + 1;
        // parents = [0:5, 1:6, 5:5, 2:6, 3:5]
        cur = parent;
        // cur = 'x'
        curIdx = parentIdx;
        // curIdx = 4
        // done=True; all iterations finished.
      }

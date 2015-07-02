--[[

  A basic tree structure.

--]]

local Tree = torch.class('treelstm.Tree')

function Tree:__init()
  self.parent = nil
  self.num_children = 0
  self.children = {}
end

function Tree:add_child(c)
  c.parent = self
  self.num_children = self.num_children + 1
  self.children[self.num_children] = c
end

function Tree:size()
-- Find the size of the Tree Structure by iterating over the children and finding the size of each of the children.
-- Check if the _size of this Tree has been predefined through some previous iterations.
  if self._size ~= nil then return self._size end
  local size = 1
  for i = 1, self.num_children do
    size = size + self.children[i]:size()
  end
  self._size = size
  return size
end

function Tree:depth()
  local depth = 0
  if self.num_children > 0 then
    for i = 1, self.num_children do
      local child_depth = self.children[i]:depth()
      if child_depth > depth then
        depth = child_depth
      end
    end
    depth = depth + 1
  end
  return depth
end

local function depth_first_preorder(tree, nodes)
  if tree == nil then
    return
  end
  -- If the tree is not nil then append the tree in the list/table nodes.
  -- When called over the topmost node, then starts returning the mini-tree structures in a depth_first fashion.
  -- Can change to breadth- first by simple layerwise iteration, i.e. Go from bottom to top.
  table.insert(nodes, tree)
  for i = 1, tree.num_children do
    depth_first_preorder(tree.children[i], nodes)
  end
end

function Tree:depth_first_preorder()
  local nodes = {}
  depth_first_preorder(self, nodes)
  return nodes
end

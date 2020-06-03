/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || inorder.empty())
            return NULL;
        return build(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1);
    }

    TreeNode* build(vector<int>& preorder, int ps, int pe, vector<int>& inorder, int is, int ie) {
        TreeNode* root = new TreeNode(preorder[ps]);
        root->left = NULL;
        root->right = NULL;
        
        int i = is;
        while(i <= ie && preorder[ps] != inorder[i])
            ++i;
        int ll = i-is;
        int rl = ie-i;
               
        if(ll > 0) {
            root->left = build(preorder, ps+1, ps+ll, inorder, is, is+ll-1);
        }
        if(rl > 0) {
            root->right = build(preorder, ps+ll+1, pe, inorder, is+ll+1, ie);
        }
        return root;       
    }
};
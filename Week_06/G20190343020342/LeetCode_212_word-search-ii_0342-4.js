// 优化版2
// 判断是否找到了，通过传递节点的END来判断，就不需要用Trie树的判断函数了，
// 性能优化不错，是这几种解法里最快的一种
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    // 构建字典树
    class TrieNode{
        constructor(){
            this.END = false;
            this.children = {};
        }
    }
    let root = null;
    let Trie = function() {
        root  = new TrieNode();
    };
    Trie.prototype.insert = function(word) {
        let currNode = root;
        for(let i = 0;i < word.length;i++){
            if(currNode.children[word[i]] == undefined){
                currNode.children[word[i]] = new TrieNode();
            }
            currNode = currNode.children[word[i]];
        }
        currNode.END = true;
    };
    // 初始化变量
    let m = board.length;
    let n = board[0].length;
    // 初始化字典树
    let wordsTrie = new Trie();
    for(let i = 0;i < words.length;i++){
        wordsTrie.insert(words[i]);
    }
    // DFS 搜索
    let boardDFS = (i,j,curStr,currNode) => {
        // 字典树中找到了
        if(currNode.END){
            result.push(curStr);  
            currNode.END = false;          
        }
        if(i <0 || j <0 || i == m || j == n){
            return;
        }
        const restore = board[i][j];
        if(restore == '#' || !currNode.children[restore]){
            return;
        }
        // 前进
        board[i][j] = '#';
        curStr += restore; 
        boardDFS(i-1,j,curStr,currNode.children[restore]);                           
        boardDFS(i+1,j,curStr,currNode.children[restore]); 
        boardDFS(i,j-1,curStr,currNode.children[restore]);                           
        boardDFS(i,j+1,curStr,currNode.children[restore]); 
        // 还原(回溯)
        board[i][j] = restore;
    }
    // 寻找结果
    let result = [];
    for(let i = 0;i < m;i++){
        for(let j = 0;j < n;j++){
            boardDFS(i,j,'',root); 
        }
    }
    return result;
};
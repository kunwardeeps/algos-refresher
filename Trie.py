class TrieNode:
    def __init__(self):
        self.children = {}
        self.item = ""

root = TrieNode()

def addWord(word):
    node = root
    for c in word:
        if c not in node.children:
            node.children[c] = TrieNode()
        node = node.children[c]
    node.item = word

def search(word):
    return match(list(word), 0, root)

def match(ch_list, k, node):
    if k == len(ch_list):
        return bool(node.item) # return True if the node is not empty
    if ch_list[k] != '.':
        c = ch_list[k]
        return c in node.children and match(ch_list, k + 1, node.children[c])
    else:
        for c, child in node.children.items():
            if child and match(ch_list, k + 1, child):
                return True
    return False

addWord("word")
addWord("hello")
print(search("word") == True)
print(search("hello") == True)
print(search("abc") == False)

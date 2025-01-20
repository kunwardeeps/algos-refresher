class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.item = ""

root = TrieNode()

def addWord(word):
    node = root
    for c in word:
        index = ord(c) - ord('a')
        if not node.children[index]:
            node.children[index] = TrieNode()
        node = node.children[index]
    node.item = word

def search(word):
    return match(list(word), 0, root)

def match(ch_list, k, node):
    if k == len(ch_list):
        return bool(node.item) # return True if the node is not empty
    if ch_list[k] != '.':
        index = ord(ch_list[k]) - ord('a')
        return node.children[index] and match(ch_list, k + 1, node.children[index])
    else:
        for child in node.children:
            if child and match(ch_list, k + 1, child):
                return True
    return False

addWord("word")
addWord("hello")
print(search("word") == True)
print(search("hello") == True)
print(search("abc") == False)
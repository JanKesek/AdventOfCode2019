def DFS(g,start,end,path=[]):
        if start==end: return path
        path.append(start)
        for v in g[start]:
                return DFS(g,v,end,path)
def graph_DFS(start,g,visited=[]):
    # Input: start vertex
    S = []
    # Mark start as visited
    S.append(start)
    while len(S) !=0:
        node = S.pop()
        # Do something? (e.g. print)
        print(node)
        for neighbor in g[node]:
            if neighbor not in visited:
                # Mark neighbor as visited
                visited.append(neighbor)
                S.append(neighbor)
def find_path(graph, start, end, path=[]):
        path = path + [start]
        if start == end: return path
        if start not in graph: return None
        for node in graph[start]:
                if node not in path:
                        newpath = find_path(graph, node, end, path)
                        if newpath: return newpath
        return None
testGraph={
        "COM":["B"],
        "B":["COM","G","C"],
        "C":["B","D"],
        "D":["C","I","E"],
        "E":["D","J","F"],
        "F":["E"],
        "G":["B","H"],
        "H":["G"],
        "I": ["D"],
        "J":["E","K"],
        "K":["J","L"],
        "L":["K"]
}
def readGraphFromFile(filename):
        realGraph={}
        f = open(filename, "r")
        for x in f:
                x=x.rstrip()
                keyVal=x.split(")")
                if keyVal[0] not in realGraph:
                        realGraph[keyVal[0]]=[]
                        if keyVal[1] not in realGraph[keyVal[0]]: realGraph[keyVal[0]].append(keyVal[1])
                else:
                        if keyVal[1] not in realGraph[keyVal[0]]: realGraph[keyVal[0]].append(keyVal[1])
                if keyVal[1] not in realGraph:
                        realGraph[keyVal[1]]=[]
                        if keyVal[0] not in realGraph[keyVal[1]]: realGraph[keyVal[1]].append(keyVal[0])
                else:
                        if keyVal[0] not in realGraph[keyVal[1]]: realGraph[keyVal[1]].append(keyVal[0])
        return realGraph
def runPaths(graph, start):
        sum=0
        for v in graph:
                if v!=start: sum+=len(find_path(graph,start,v))-1
        print(sum)
print(find_path(testGraph,"COM","J"))
print(find_path(testGraph,"COM","H"))


g1=readGraphFromFile("intday6Test.txt")
g2=readGraphFromFile("intday6.txt")
g3=readGraphFromFile("intday6Test2.txt")

print(runPaths(testGraph, "COM"))
print(runPaths(g1, "COM"))
#print(runPaths(g2, "COM"))

print(len(find_path(g3, "YOU","SAN"))-3)
print(len(find_path(g2, "YOU","SAN"))-3)


class Wire:
        def __init__(self, line,xC,yC):
                self.directions=line.split(",")
                self.x=xC
                self.y=yC
                self.points=[]
        def parse(self):
                for direction in self.directions:
                        if direction[0]=='L': self.goLeft(int(direction[1:]))
                        if direction[0]=='R': self.goRight(int(direction[1:]))
                        if direction[0]=='U': self.goUp(int(direction[1:]))
                        if direction[0]=='D': self.goDown(int(direction[1:]))
        def goLeft(self,delta):
                for i in range(self.x,self.x-delta,-1):
                        if len(self.points)!=0:                        
                                if [i,self.y]!=self.points[-1]: self.points.append([i,self.y])
                        else: self.points.append([i,self.y])
                self.x-=delta
        def goRight(self,delta):
                for i in range(self.x, self.x+delta):
                        if len(self.points)!=0:
                                if [i,self.y]!=self.points[-1]: self.points.append([i,self.y])
                        else: self.points.append([i,self.y])
                self.x+=delta
        def goUp(self,delta):
                for i in range(self.y,self.y-delta,-1):
                        if len(self.points)!=0:
                                if [self.x,i]!=self.points[-1]: self.points.append([self.x,i])
                        else: self.points.append([self.x,i])
                self.y-=delta
        def goDown(self,delta):
                for i in range(self.y, self.y+delta):
                        if len(self.points)!=0:
                                if [self.x,i]!=self.points[-1]: self.points.append([self.x,i])
                        else: self.points.append([self.x,i])
                self.y+=delta
        def getLines(self):
                if len(self.points)<100000: print(self.points)
                return self.points
def manhattan(point,xC,yC):
        return abs(point[0]-xC)+abs(point[1]-yC)

def findDistance(lst,xC,yC):
        print("Taking intersection")
        lst2=list(set(map(tuple,lst[0])).intersection(set(map(tuple,lst[1]))))
        lst2=list(map(list,lst2))
        
        print("Finished with intersection")
        if [xC,yC] in lst2: lst2.remove([xC,yC])
        with open('output1.txt', 'w') as f:
                print(lst2, file=f)
        print(lst2)
        listOfSteps1=[]
        listOfSteps2=[]
        for i in lst2:
                listOfSteps1.append(lst[0].index(i))
                listOfSteps2.append(lst[1].index(i))
        assert(len(listOfSteps1)==len(listOfSteps2))
        sumsOfSteps=[]
        for i in range(len(listOfSteps1)):
                sumsOfSteps.append(listOfSteps1[i]+listOfSteps2[i])
        print("SMALLEST SUM OF STEPS: ", min(sumsOfSteps))
        shortest=1000000000000000
        for p in lst2:
                s=manhattan(p,xC,yC)
                if s<=shortest: shortest=s
        return shortest
def test(strArr):
        pointsAB=[]
        xC=0
        yC=0
        for line in strArr:
                w=Wire(line,xC,yC)
                w.parse()
                pointsAB.append(w.getLines())
        return findDistance(pointsAB,xC,yC)
                
test1=["R75,D30,R83,U83,L12,D49,R71,U7,L72","U62,R66,U55,R34,D71,R55,D58,R83"]
print(test(test1))
test2=["R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"]
print(test(test2))
listOfWiresLines=[]
f=open("input", "r")
for line in f:
        listOfWiresLines.append(line)
print(test(listOfWiresLines))

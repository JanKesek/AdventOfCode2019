class Wire:
        def __init__(self, line,xC,yC,intersections):
                self.directions=line.split(",")
                self.x=xC
                self.y=yC
                self.points=[]
                self.steps=0
                self.intersections=intersections
                self.intersectionSteps=[]
        def parse(self):
                for direction in self.directions:
                        if direction[0]=='L': self.goLeft(int(direction[1:]))
                        if direction[0]=='R': self.goRight(int(direction[1:]))
                        if direction[0]=='U': self.goUp(int(direction[1:]))
                        if direction[0]=='D': self.goDown(int(direction[1:]))
                        #self.steps+=1
        def goLeft(self,delta):
                for i in range(self.x-delta,self.x):
                        self.points.append([i,self.y])
                        self.checkIfIntersection(i,self.y)
                self.x-=delta
        def goRight(self,delta):
                for i in range(self.x, self.x+delta):
                        self.points.append([i,self.y])
                        self.checkIfIntersection(i,self.y)
                self.x+=delta
        def goUp(self,delta):
                for i in range(self.y-delta,self.y):
                        self.points.append([self.x,i])
                        self.checkIfIntersection(self.x,i)
                self.y-=delta
        def goDown(self,delta):
                for i in range(self.y, self.y+delta):
                        self.points.append([self.x,i])
                        self.checkIfIntersection(self.x,i)
                self.y+=delta
        def checkIfIntersection(self,x,y):
                self.steps+=1
                if [x,y] in self.intersections:
                        #self.steps+=1
                        self.intersectionSteps.append(self.steps)
        def getLines(self):
                return self.points
        def getIntersectionSteps(self):
                return self.intersectionSteps
def test(intersLst, wiresLst):
        lstSteps=[]
        stepsSums=[]
        for line in wiresLst:
                w=Wire(line,1000000,1000000,intersLst)
                w.parse()
                lstSteps.append(w.getIntersectionSteps())
        assert(len(lstSteps[0]) == len(lstSteps[1]))
        for i in range(len(lstSteps[0])):
                stepsSums.append(lstSteps[0][i]+lstSteps[1][i])
        print(stepsSums)
        print("FOUND MINIMUM " + str(min(stepsSums)))                
testIntersections1=[[1000158, 1000012], [1000155, 999996], [1000146, 999954], [1000155, 999989]]
testIntersections2=[[1000107, 999953], [1000124, 999989], [1000157, 999982], [1000107, 999929], [1000107, 999949]]
lstOfIntersections=[[999596, 998638], [999588, 998181], [999801, 998181], [1000099, 997962], [999519, 999258], [998261, 997931], [999636, 997381],
                    [999596, 998730], [999801, 998627], [999550, 999704], [999619, 998730], [999057, 1000000], [998261, 998089], [999588, 998237],
                    [999519, 999474], [999565, 999704], [999519, 999408], [999057, 999878], [999816, 998730], [999519, 999671], [999619, 998638]]
test1Wires=["R75,D30,R83,U83,L12,D49,R71,U7,L72","U62,R66,U55,R34,D71,R55,D58,R83"]
print("test1 length" + str(len(test1Wires[0].split(","))+len(test1Wires[1].split(","))))
test2Wires=["R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"]
print("test1 length" + str(len(test2Wires[0].split(","))+len(test2Wires[1].split(","))))
listOfWiresLines=[]
f=open("input", "r")
for line in f:
        listOfWiresLines.append(line)
print(test(testIntersections1,test1Wires))
print(test(testIntersections2,test2Wires))
print(test(lstOfIntersections,listOfWiresLines))

        

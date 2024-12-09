<h1>
  J2EE
  </h1>

<ul>
<li>Hibernate-Core</li>
<li>Maven Project</li>
<li>Adding Servers</li>
<li>HQL Queries</li>
</ul>
<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>-<br>

<pre>
                                                                  <h3>Notes as per Date</h3>
  J2EE 15 OCTOBER 2024:

Maven project major advantage is --> We can add dependencies instead of jar files

--------------------------------x---------------------------------x-----------------------------------
Process to make maven project:-
New
Maven project
Choose Internal catlouge
Select Maven archetype quick start
Enter Group Id and artifact Id
Make new  Package com.mycompany
 enter y in the terminal
------------------------x---------------------------------------x---------------------------------

Making table content for hibernate:-
Src -> package name -> App.java
New class -> student
Private Integer roll;
Private String name;
Private Double percent;
Source -> generate getter and setters -> select all -> generate
Anotation at the start of the class       
        =>   @Entity -> table name 
       =>    @id -> primary key
In Google -> search maven repository ->hibernate core -> 6.2.14 - >copy dependencies
paste dependencies in Pom.xml 

Rigth click on Project ->  maven ->  update project

---------------------------x------------------------------------x-----------------------------------
 Hibernate configurations:-
In Src -> main-> java (inbuild function for maven hibernate xml file)
Make New file hibernate.cfg.xml
Search Hibernate.cfg.xml on google -> open the server side -> copy the 
Windows -> preferences -> xml wild web developer -> download xml resource -> apply and close ( To get rid of all the errors in the property )

====>Properties and other included in hibernate.cfg.xml file
#  Property connection  
#  Property connection url - >localhost/dtabasename se
#  Property  dialect 
#  Property username
#  Property password
#  Property show sql
#  <Mapping class = “packagename.classname”/> 
#  Prroperty     update

Save

---------------------------x---------------------------------x--------------------------

For mysql connector instead of jar files:- 
In Google -> search maven repository -> Mysql connector -> 9.0.0 - >copy dependencies
Dependency paste in pom.xml

Mysql -u root -p ( command to start mysql in shell)

Only Create database in sql


---------------------------x---------------------------------x--------------------------

In file App.java
Configuration cfg = new Configuration(); // using Configuration of org.hibernate
Cfg.comfigure();
SessionFactory sf = cfg.buildSessionFactory();
Session sess = sf.openession(); // Session interface
Student s = new student();
s.setRoll(101);
s.setName(“Ramlal”);
s.setPercent(90.9);
Transaction tx = sess.getTransaction();
Sess.save(s);
Tx.commit();
Sess.close();
Syso(“Done”);

----------------------------------x---------------------------------x---------------------------------

19 oct 2024:-
Student.java
@Table(name=”stu”) to change table name
@GeneratedValue(strategy = GenerationTypew.IDENTITY) Auto increment
@Column(name=”empid” , length =100) to change column name
@Transient to not make the column in table like int x;
@Temporal(TemporalType.DATE) to only print date
Date date;
@Lob  =large object
@Column(name=”iamge” , columnDefinition= “LONGBLOB” )
Byte image[]
Boolean isOpen;

----------------------------------x---------------------------------x---------------------------------

App.java

Insert try catch block

s.setX(100);
s.setid(12);
s.setIsOpen(true);
s.setDate(new Date());  import Date from the util package
s.setOpen(true);

Image insert:-
Copy image in the src/main/java 
FileInputstream fis = new fileinputstream(“”);
Available file size 
Byte b[] = new byte[fis.available()];
Fis.read(b);
s.setimage(b);

----------------------------------x---------------------------------x---------------------------------


Make Employee class 
Column name =
Int id ;
Srting emp_name;
Double salary;
Runtime data entry   scanner object pass the value on s.setRoll(roll);
Update add new entry to table 
Create 

----------------------------------x---------------------------------x---------------------------------

22 october 2024:-
Depicting relations
Association == relation between two independent classes  one to one ……...
Aggregation == one class is dependent to another class 
Composition = = stronger form of relation dependency

----------------------------------x---------------------------------x---------------------------------

One to one relationship:
Question class answer class 


Question.java
Int qid
String question
@OnetoOne
Answer a
Getter setter

Answer.java
Int aid 
String answer;
@OnetoOne
@OnetoOne(mapedby = “ans”)  object from where the reference is mapped
Question ques;
Getter setter

Two mapping line for both question and answer
App.java
Question q1 = new question();
Q1.setqid
Q1.setquestion
Same for question 2 and 3
Answer a1 = new answer();
A1.setaid
A1.setanswer
Same for answer 2 and 3
Q1.setans(a1);
Same for a2 and a3 for relating both
A1.setques(q1)
Same for q2 and q3 for relating both  ==== bidirectional

----------------------------------x---------------------------------x---------------------------------

23 october 2024:-

One to many relationship:

Question.java


OnetoMany  3 tables are made
OnetoMany(mappedBy = “ques”)     tables are made
List<Answer> ans; because there are many answer to one question that’s why making list




Answer.java
@manytoOne


App.java

Question object
Answer object
List<Answer> l  = new ArrayList();
l.add(a1); same for rest2 answers
q.setAns(l);
For(Answer a:l){   a.setQues(q);}



Cascade: one info will save to the same place to the previous info
@OnetoMany(cascade = cascadeType.All)

----------------------------------x---------------------------------x---------------------------------

24 october 2024:-

Many to Many

Question.java

@ManytoMany (cascade =cascadeType.ALL)
List<Answer> ans;

Answer.java

@Manytomany(mappedBy = “ques”)

List<Question> ques;


App.java
Question object  q1 q2 q3
Answer object a1 a2 a3
List<Answer> l1= new ArrayList();
l.add(a1); same for rest2 answers
List<Question> l2 = new ArrayList();
l.add(q1); same for rest2 answers
For(Question q:l2){   q.setAns(l1);}
For(Answer a:l1){   a.setQues(l2);}


----------------------------------x---------------------------------x---------------------------------

25 october 2024:-

Update :-

New file crud
Add dependencies
Make employee class id name salary
Getter setters

App.java DELETE
Make object , set id name salary
Sess.persist(e)  save method is deprecated
Sess.delete(e) 

App2.java SELECT
Employee emp = (Employee)sess.get(Employee.class,102)  
run select  query for only one

Load method same as get
Employee emp = (Employee)sess.load(Employee.class,102)  

App3.java UPDATE
Employee emp = (Employee)sess.get(Employee.class,102)  
Emp.setName(“Kabulal”)
Transaction object
Sess.update(emp)
Transaction commit
Session close

----------------------------------x---------------------------------x---------------------------------
Assignment:-
difference between save and persist
Why save is deprecated
Why use persist rather than save

----------------------------------x---------------------------------x---------------------------------
Core student data
=>Enter 1 to insert 
           Enter roll no
           Enter name
           Enter percentage
=>Enter 2 to update 
           Enter roll no
           Enter 1 to update name
           Enter 2 to update percentage
=>Enter 3 to get 
          Enter roll no
          print Rollno = 
          student name = 
          student percentage= 
=>Enter 4 to Delete
            Enter roll no

----------------------------------x---------------------------------x---------------------------------

26 October 2024:-

Get : - 
== In select get method the object created and displayed shows null 
== early running of select query 
== this method gets the data from database as soon as it is called
== the method returns null if the object is not found
==this method should be used if we are unshure about the existence of the data in the database
Load : -
== But load shows objectnot found exception 
== only run the select query when object is used 
== this method returns a proxy object nad load the data only when it is required
== the method throws objectNotFoundException if the object is not found
== this method is to be used when we know for sure that the data is present in the database

Caching:  
Two types: 
              First level caching =  (default) = upto session = 
              Second level caching  = (need to applied) =  upto session factory = 
Cache diagram: hibernate in built cache 
Java application ---- > request ---> database -- >response --> cache memory -- >java applivcation


----------------------------------x---------------------------------x---------------------------------
28 October 2024:-

Maven repositories
Ehcaching 3.0.
Hibernate ehcaching version same as hibernate core
Hibernate.cfg.xml
<property name=”cache.use_second_level_cache”>true</property>
Ctrl shift t  ehcache region factory === package name.CLASSNAME
<property name=”cache.region.factory_class”>package ka name</property>
@cacheable
@cache(usage = CacheConcurrencyStrategy.READ_ONLY  )
Tomcat 9 or low  javax tomcat 10 jakarta


----------------------------------x---------------------------------x---------------------------------

4th November 2024:-


Org.hiibernate.cache.ehcache.internal.ehchacheregionfactory
Ehcache 5.4.5 final org hibernate



----------------------------------x---------------------------------x---------------------------------
5th November 2024:-

Hibernate architecture: 4 Layers
Java application layer  === main method , class files ===  persistent object == student or employee object made for table creation
Hibernate framework layer = = Configuration, sessionFactory, Session, Transaction, Query, Criteria
Backend API layer 
    ==== > JNDI = Java Naming and Directory Interface
    ==== > JTA = Java Transaction API
Database layer

HQL (Hibernate Query Language) Query used for
 selecting multiple data 
From student; HQL query

Query q  = session.createQuery(“from empl”);
List <employee> l  = q.List();
For(Employee e:l){
e.getName()}

----------------------------------x---------------------------------x---------------------------------
6th November 2024:-


From /employee where name=””;
Value at run time 
  from Employee where name =:n;
   q.setparameter(“n”, name);

from Employee where salary >=:min and salary >=:max;
   q.setparameter(“min”, ms);
  q.setparameter(“max”, mxs);

q.setFirstResult(5); //starting point of selecting
q.setMaxResult(4);  // number of records to be fetched 




----------------------------------x---------------------------------x---------------------------------
7th November 2024:-


FULL QUERY
Query q = Sess.createnativequery(insert into Employee values(?,?,?));
q.setparameter(1,1000)
Transaction also used
Query q = Sess.createnativequery(select * from Employee);
List<Object[]> l = q.List();
For(object[] o: l){ for(Object oo :o){    syso(oo)}}

Hibernate states: there are 4 states:
Transisnt state === entity object made and getter and setter method are called 
Pesistent state === save update delete on session
Detached state === session close /clear
Remove state === sess.delete





----------------------------------x---------------------------------x---------------------------------

</pre>

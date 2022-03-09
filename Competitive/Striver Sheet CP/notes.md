## STRING HASHING

1)
  ## comparing two string is a task of O(n)
  ## which is costly if we are performing some other with it to
  ## so we store hash value corresponding to each string 
  ## let say for string s1 and s2 we have hashvalue h1 and h2
  ## and hash values are unique for each string and since they are integer they can be compared in O(1)

2) 
   ## how is a string hash has created ?
   2.1)
   ## for ex s = 'pepper'
   ## we take a prime no pr = 31 (why 31=> we need to have it higher that chracter set for this case we have character set = 26) ( if we take prime no less than character set we would face hash collision which means two strings might have same hash value)

   
   ## hash = (P*(pr)^0 + E*(pr)^1 + P*(pr)^2 + P*(pr)^3 + E*(pr)^4 + R*(pr)^5) % mod
   ## where P = ('p'-'a'+1) E = ('e'-'a'+1)  etc
   ## but this is also a O(n) task

   2.2)
   ## RABIN KARP ROLLING HASH (Notebook)

     
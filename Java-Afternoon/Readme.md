## Java-Afternoon Assignment

**Name:** Kunal Sharma

**Email:** kunalsharma6914@gmail.com

### Merging of two xml files based on Keys
##### **Keys** : NIPR_Number,StateCode, licenseNumber,EffectiveDate

## 1. Write Merged List to a File

### **Solution** - `XMLParser.java`

1. Parsing License1.xml and License2.xml and Created a Hashmap of <NIPR_Number, [CSR_Producer...]> so to find all CSR_Producer tags with same NIPR_Number.
2. Now Created Another Hashmap<StateCode+licenseNumber+EffectiveDate`a unique key`, [License]> so to find all the Licenese under the same NIPR_Number with same StateCode, licenseNumber and EffectiveDate.
3. Now wrote the merged results to `merged.xml` file.

### **Output** - `Creates 1 XML File (merged.xml) - Merging the Nodes based on Keys specified above`

### 2. Write Valid Licenses to a File (Valid.xml) and Invalid Licenses to a File (Invalid.xml) on `License_Expiration_Date`.

### **Solution** - `ValidLicense.java`

1. Parsing merged.xml and getting the Epiration Date from the License Node.
2. Now compare this date to today's date and depending upon that comparison, moving the particular License Node (and it's child nodes) to corresponding file (valid.xml OR invalid.xml)

### **Output** - `Created 2 XML File (valid.xml and invalid.xml) - Writing Valid Licenses to valid.xml and Invalid Licenses to invalid.xml based on License_Expiration_Date`


### Running and Installation

1. Simply clone this repo and run the file in the particular order

```
javac XMLParser.java
java XMLParser
```

It will create the file `merged.xml`

2. Now run

```
javac ValidLicense.java
java ValidLicense
```

It will create two files `valid.xml` and `invalid.xml`

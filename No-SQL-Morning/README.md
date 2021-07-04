## No SQL Assignment

**Name:** Kunal Sharma
**Email** kunalsharma6914@gmail.com

### 1. Import `beer-sample` bucket

#### Beer Bucket

![Beer Sample Bucket](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/beer-bucket.png)

#### Select Query on Beer Bucket

![Select Beer Bucket](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/select-beer-bucket.png)

### 2. Write a join query to fetch the Top 10 brewery(type=”beer”) and their country(type=”brewery”) which produces more varieties of beers.

![Join Query](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/join.png)

### 3. Write a mapreduce to get the number of breweries based on country.

#### Map Query

![Map Query](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/map-query.png)

#### Map Query Output

![Map Query Output](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/map-output.png)

### 4.XDCR

#### 1. Add Bucket Brewery

#### Adding New Bucket

![Add Bucket Brewery](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/add-bucket-cmd.png)

##### Bucket Brewery

![Bucket Brewery](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/brewery-bucket.png)

#### 2. Create a XDCR with a filter(type=’brewery’) to replicate only the brewery entity from `beer-sample` bucket.


![Filter XDCR](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/filter-xdcr.png)

### 5. CLI

#### 1. Add a new bucket “Beer”.

![Bucket Created](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/cli-bukcet-created.png)

#### 2. Using CLI - do a cbexport of the entire `beer-sample`

![Export](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/export.png)

#### 3. do a cbimport with “brewery_id” as primary key. As a result, in the new bucket - only “beer” documents will be imported with their respective brewery name as meta().id

#### Command

![cbimport cmd](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/cbimport_cmd.png)

#### CBImport Terminal Output

![cbimport cmd output](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/cbimport_res1.png)

#### Beer Bucket Now have 1329 Documents (After Import)

![Beer Bucket](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/No-SQL-Morning/img/Beer_bucket.png)

## 🌎 Java Wiki Api

![GitHub License](https://img.shields.io/github/license/MasterFlomaster1/java-wiki-api)
![GitHub Release](https://img.shields.io/github/v/release/MasterFlomaster1/java-wiki-api)


Java Wiki Api is a comprehensive tool for flexible creation of detailed queries to the Wikipedia online encyclopedia.

> [!CAUTION]
> This project is still in very early stages of development. Use at your own risk.

### Getting started
Download the latest build on the [releases page](https://github.com/MasterFlomaster1/java-wiki-api/releases).

### Usage

Requirements: Java 17 and above

```java
WikiApi api = new WikiApi();

var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder().build())
        .build();

Response r = api.execute(a);
```

#### Actions:

| Name             | Description                                                                      |
|------------------|----------------------------------------------------------------------------------|
| antispoof        | Check a username against AntiSpoof's normalisation checks                        |
| block            | Block a user                                                                     |
| centralauthtoken | Fetch a centralauthtoken for making an authenticated request to an attached wiki |
| checktoken       | Check the validity of a token                                                    |
| compare          | Get the difference between two pages                                             |
| createaccount    | Create a new user account                                                        |
| delete           | Delete a page                                                                    |
| emailuser        | Email a user                                                                     |
| languagesearch   | Search for language names in any script                                          |
| opensearch       | Search the wiki using the OpenSearch protocol                                    |
| parse            | Parses content and returns parser output                                         |
| query            | Fetch data from and about MediaWiki                                              |
| review           | Review a revision by approving or de-approving it                                |
| shortenurl       | Shorten a long URL into a shorter one                                            |
| sitematrix       | Get Wikimedia sites list                                                         |
| spamblacklist    | Validate one or more URLs against the spam block list                            |
| thank            | Send a thank-you notification to an editor                                       |
| titleblacklist   | Validate a page title, filename, or username against the TitleBlacklist          |
| torblock         | Check if an IP address is blocked as a Tor exit node                             |
| validatepassword | Validate a password against the wiki's password policies                         |
| watch            | Add or remove pages from the current user's watchlist                            |

#### Props:

| Name         | Description                                                                              |
|--------------|------------------------------------------------------------------------------------------|
| categories   | List all categories the pages belong to                                                  |
| categoryinfo | Returns information about the given categories                                           |
| contributors | Get the list of logged-in contributors and the count of anonymous contributors to a page |
| extlinks     | Returns all external URLs (not interwikis) from the given pages                          |
| fileusage    | Find all pages that use the given files                                                  |
| globalusage  | Returns global image usage for a certain image                                           |
| imageinfo    | Returns file information and upload history                                              |
| images       | Returns all files contained on the given pages                                           |
| info         | Get basic page information                                                               |
| isreviewed   | Determine if a page is marked as reviewed                                                |
| pageviews    | Shows per-page pageview data                                                             |
| redirects    | Returns all redirects to the given pages                                                 |
| revisions    | Get revision information                                                                 |
| templates    | Returns all pages transcluded on the given pages                                         |
| videoinfo    | Extends imageinfo to include video source (derivatives) information                      |


#### List:

| Name          | Description                                  |
|---------------|----------------------------------------------|
| allcategories | Enumerate all categories                     |
| allfileusages | List all file usages, including non-existing |
| allimages     | Enumerate all images sequentially            |
| recentchanges | Enumerate recent changes                     |
| usercontribs  | Get all edits by a user                      |
| users         | Get information about a list of users        |

#### Meta:

| Name           | Description                                  |
|----------------|----------------------------------------------|
| globaluserinfo | Show information about a global user         |
| languageinfo   | Return information about available languages |
| siteinfo       | Return general information about the site    |
| siteviews      | Shows sitewide pageview data                 |
| tokens         | Gets tokens for data-modifying actions       |
| userinfo       | Get information about the current user       |

### Contributing
Feel free to open an issue if you've found a bug or want to raise a question, or discuss a possible feature.
Any help is appreciated :)

### Examples

##### Get a list of categories the page Albert Einstein belongs to
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new CategoriesProp.Builder()
                                        .clLimit(10)
                                        .clDir(Dir.ASCENDING)
                                        .build()
                                )
                        )
                        .titles(Set.of("Albert Einstein"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getCategories());
```

##### Fetch site information.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteInfoMeta.Builder()
                                        .siProp(Set.of(
                                                SiteInfoMeta.SiProp.GENERAL,
                                                SiteInfoMeta.SiProp.NAMESPACES,
                                                SiteInfoMeta.SiProp.NAMESPACE_ALIASES,
                                                SiteInfoMeta.SiProp.STATISTICS
                                        ))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getGeneral());
```

##### Return information for user Example.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new UsersList.Builder()
                                        .usProp(Set.of(
                                                UsersList.UsProp.GROUPS,
                                                UsersList.UsProp.EDIT_COUNT,
                                                UsersList.UsProp.GENDER
                                        ))
                                        .usUsers(Set.of("Example"))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getUsers());
```

##### Show contributors to the page Main Page.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ContributorsProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getContributors());
```

##### Get a list of external links on the page Main Page.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ExtLinksProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getExtLinks());
```

##### Fetch information about versions of File:Test.jpg from 2008 and later.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .iiProp(Set.of(ImageInfoProp.IIProp.TIMESTAMP,
                                                ImageInfoProp.IIProp.USER,
                                                ImageInfoProp.IIProp.URL
                                        ))
                                        .iiLimit(50)
                                        .iiEnd(LocalDateTime.of(2007, 12, 31, 23, 59, 59))
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Test.jpg"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getImageInfo().get(0));

```
##### Get a list of files used on the page Main Page.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImagesProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getImages());
```

##### Get information about the page Main Page.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                        new InfoProp.Builder()
                                                .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0));
```

##### Show pageview statistics for the main page.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new PageViewsProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getPageViews());
```

##### Get last 5 revisions of the Main Page.
```java
var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvProp(Set.of(
                                                RevisionsProp.RvProp.TIMESTAMP,
                                                RevisionsProp.RvProp.USER,
                                                RevisionsProp.RvProp.COMMENT
                                        ))
                                        .rvLimit(5)
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getQuery().getPages().get(0).getRevisions());
```
##### Check if the IP address 192.0.2.18 is blocked as a Tor exit node.
```java
var a = new WikiApiRequest.Builder()
                .action(new TorBlockAction.Builder()
                        .ip("192.0.2.18")
                        .build()
                )
                .build();

Response r = api.execute(a);
System.out.println(r.getTorBlock());
```

Please refer to the [Wikipedia API Sandbox](https://en.wikipedia.org/wiki/Special:ApiSandbox) for in-depth exploration.


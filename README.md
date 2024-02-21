## 🌎 Java Wiki Api

Java Wiki Api is a comprehensive tool for flexible creation of detailed queries to the Wikipedia online encyclopedia.

### Getting started
Download the latest build on the [releases page](https://github.com/MasterFlomaster1/java-wiki-api/releases).

### Usage

```java
WikiApi api = new WikiApi();

var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder().build())
        .build();

Response r = api.execute(a);
```

Requirements: Java 17 and above

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
Please refer to the [Wikipedia API Sandbox](https://en.wikipedia.org/wiki/Special:ApiSandbox) for in-depth exploration.


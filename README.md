## 🌎 Java Wiki Api

[![build](https://github.com/MasterFlomaster1/java-wiki-api/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/MasterFlomaster1/java-wiki-api/actions/workflows/build.yml)
![GitHub License](https://img.shields.io/github/license/MasterFlomaster1/java-wiki-api)
![Maven Central](https://img.shields.io/maven-central/v/io.github.masterflomaster1/java-wiki-api)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/dc6369acab554b63921e5502baa3df26)](https://app.codacy.com/gh/MasterFlomaster1/java-wiki-api/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

Java Wiki Api is a comprehensive tool for flexible creation of detailed queries to the Wikipedia online encyclopedia.
It uses declarative approach and provides built-in types for results.

## Installation

This library is available on maven central. The latest version is always shown in the [releases page](https://github.com/MasterFlomaster1/java-wiki-api/releases).

The build requires JDK 17 or later.

### Maven

```xml
<dependency>
    <groupId>io.github.masterflomaster1</groupId>
    <artifactId>java-wiki-api</artifactId>
    <version>0.11.0</version>
</dependency>
```

### Gradle
```grale
dependencies {
    implementation("io.github.masterflomaster1:java-wiki-api:0.11.0")
}
```

## Usage

This section explains the basic principles of working with the **MediaWiki API**, commonly used in Wikipedia and other MediaWiki-based projects. The API allows you to retrieve and manipulate wiki data by sending requests with specific parameters like **action**, **prop**, **list**, and **meta**.

```java
WikiApi api = new WikiApi();

var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder().build())
        .build();

Response r = api.execute(a);
```

### 1. Action

The `action` parameter defines what action the API should perform. Supported actions:

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

**Example:**

```java
var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder().build())
        .build();
```

### 2. Properties

When using `query` action, the prop parameter specifies which properties of pages or objects you want to retrieve. This includes page content, contributors, templates, and more. Supported props:

| Name            | Description                                                                              |
|-----------------|------------------------------------------------------------------------------------------|
| categories      | List all categories the pages belong to                                                  |
| categoryinfo    | Returns information about the given categories                                           |
| contributors    | Get the list of logged-in contributors and the count of anonymous contributors to a page |
| extlinks        | Returns all external URLs (not interwikis) from the given pages                          |
| fileusage       | Find all pages that use the given files                                                  |
| globalusage     | Returns global image usage for a certain image                                           |
| imageinfo       | Returns file information and upload history                                              |
| images          | Returns all files contained on the given pages                                           |
| info            | Get basic page information                                                               |
| isreviewed      | Determine if a page is marked as reviewed                                                |
| linkshere       | Find all pages that link to the given pages                                              |
| links           | Returns all links from the given pages                                                   |
| pageviews       | Shows per-page pageview data                                                             |
| redirects       | Returns all redirects to the given pages                                                 |
| revisions       | Get revision information                                                                 |
| templates       | Returns all pages transcluded on the given pages                                         |
| transcodestatus | Get transcode status for a given file page                                               |
| videoinfo       | Extends imageinfo to include video source (derivatives) information                      |

**Example:**

Returns all files contained on the [wikipedia page about Java](https://en.wikipedia.org/wiki/Java_(programming_language))

```java
var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder()
                .prop(Set.of(new ImagesProp.Builder().build()))
                .titles(Set.of("Java (programming language)"))
                .build()
        )
        .build();
```

### 3. Lists

The `list` parameter is used to retrieve lists of various objects, such as pages, categories, users, or links. Supported lists:

| Name             | Description                                           |
|------------------|-------------------------------------------------------|
| allcategories    | Enumerate all categories                              |
| allfileusages    | List all file usages, including non-existing          |
| allimages        | Enumerate all images sequentially                     |
| alllinks         | Enumerate all links that point to a given namespace   |
| allpages         | Enumerate all pages sequentially in a given namespace |
| allusers         | Enumerate all registered users                        |
| backlinks        | Find all pages that link to the given page            |
| betafeatures     | List all BetaFeatures                                 |
| blocks           | List all blocked users and IP addresses               |
| categorymembers  | List all pages in a given category                    |
| exturlusage      | Enumerate pages that contain a given URL              |
| filearchive      | Enumerate all deleted files sequentially              |
| imageusage       | Find all pages that use the given image title         |
| prefixsearch     | Perform a prefix search for page titles               |
| projects         | List all the projects                                 |
| protectedtitles  | List all titles protected from creation               |
| random           | Get a set of random pages                             |
| recentchanges    | Enumerate recent changes                              |
| tags             | List change tags                                      |
| usercontribs     | Get all edits by a user                               |
| users            | Get information about a list of users                 |

**Example:**

List recent changes.

```java
var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder()
                .list(Set.of(new RecentChangesList.Builder().build()))
                .build()
        )
        .build();
```

### 4. Meta

The `meta` parameter is used to retrieve general information about the wiki, users, or statistics. Supported meta:

| Name           | Description                                  |
|----------------|----------------------------------------------|
| globaluserinfo | Show information about a global user         |
| languageinfo   | Return information about available languages |
| siteinfo       | Return general information about the site    |
| siteviews      | Shows sitewide pageview data                 |
| tokens         | Gets tokens for data-modifying actions       |
| userinfo       | Get information about the current user       |

**Example:**

Show sitewide pageview totals.

```java
var a = new WikiApiRequest.Builder()
        .action(new QueryAction.Builder()
                .meta(Set.of(
                        new SiteViewsMeta.Builder()
                                .pvIsMetric(SiteViewsMeta.PvIsMetric.UNIQUES)
                                .build()
                ))
                .build()
        )
        .build();
```

## Contributing
Feel free to open an issue if you've found a bug or want to raise a question, or discuss a possible feature.
Any help is appreciated :)

## More Examples

- Actions
  - antispoof
    - [Check username "Foo" against AntiSpoof](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/AntiSpoofActionTest.java#L17)
  - block
    - [Block IP address 192.0.2.5 for three days with a reason](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/BlockActionTest.java#L21)
    - [Block user Vandal indefinitely with a reason, and prevent new account creation and email sending](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/BlockActionTest.java#L40)
  - centralauthtoken
    - [Fetch a centralauthtoken](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/CentralAuthTokenActionTest.java#L16)
  - checktoken
    - [Test the validity of a csrf token](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/CheckTokenActionTest.java#L16)
  - compare
    - [Create a diff between revision 1246320177 and 1242717618](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/CompareActionTest.java#L18)
  - delete
    - [Delete Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/DeleteActionTest.java#L16)
    - [Delete Main Page with the reason Preparing for move](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/DeleteActionTest.java#L33)
  - emailuser
    - [Send an email to the user WikiSysop with the text Content](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/EmailUserActionTest.java#L18)
  - languagesearch
    - [Search for "Te"](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/LanguageSearchActionTest.java#L17)
    - [Search for "ഫി"](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/LanguageSearchActionTest.java#L33)
    - [Search for "ഫി", allowing one typo](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/LanguageSearchActionTest.java#L49)
  - opensearch
    - [Find pages beginning with Te](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/OpenSearchActionTest.java#L22)
  - parse
    - [Parse a page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ParseActionTest.java#L19)
    - [Parse wikitext](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ParseActionTest.java#L35)
    - [Parse wikitext, specifying the page title](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ParseActionTest.java#L52)
  - query
    - [Fetch site info and revisions of Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/QueryActionTest.java#L21)
  - review
    - [Approve revision 12345 with comment "Ok"](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ReviewActionTest.java#L17)
  - shortenurl
    - [Get the short URL for https://en.wikipedia.org/wiki/Arctica](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ShortenUrlActionTest.java#L15)
    - [Get a QR code for https://en.wikipedia.org/wiki/Arctica](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ShortenUrlActionTest.java#L31)
  - sitematrix
    - [Show the site matrix](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/SiteMatrixActionTest.java#L17)
  - spamblacklist
    - [Check two URLs against the block list](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/SpamBlacklistActionTest.java#L17)
  - thank
    - [Send thanks for revision ID 456, with the source being a diff page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ThankActionTest.java#L17)
  - titleblacklist
    - [Check whether Foo is blacklisted](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/TitleBlacklistActionTest.java#L15)
    - [Check whether Bar is blacklisted for editing](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/TitleBlacklistActionTest.java#L31)
  - torblock
    - [Check if the IP address 192.0.2.18 is blocked as a Tor exit node](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/TorBlockActionTest.java#L17)
  - validatepassword
    - [Validate the password foobar for the current user](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ValidatePasswordActionTest.java#L15)
    - [Validate the password qwerty for creating user Example](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/ValidatePasswordActionTest.java#L31)
  - watch 
    - [Watch the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/WatchActionTest.java#L19)
    - [Watch the pages Main Page, Foo, and Bar for one month](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/WatchActionTest.java#L36)
    - [Unwatch the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/action/WatchActionTest.java#L54)

- List
  - allcategories
    - [List categories with information on the number of pages in each](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllCategoriesListTest.java#L21)
  - allfileusages
    - [List file titles, including missing ones, with page IDs they are from, starting at B](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllFileUsagesListTest.java#L20)
    - [List unique file titles](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllFileUsagesListTest.java#L42)
  - allimages
    - [Show a list of files starting at the letter B](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllImagesListTest.java#L26)
    - [Show a list of recently uploaded files, similar to Special:NewFiles](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllImagesListTest.java#L46)
  - alllinks 
    - [List linked titles, including missing ones, with page IDs they are from, starting at B](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllLinksListTest.java#L21)
  - allpages
    - [Show a list of pages starting at the letter B](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllPagesListTest.java#L22)
  - allusers
    - [List users starting at Y](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/AllUsersListTest.java#L22)
  - backlinks
    - [Show links to Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/BacklinksListTest.java#L22)
  - betafeatures 
    - [Get all available beta features and show how many users have enabled them](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/BetaFeaturesListTest.java#L18)
  - blocks
    - [List blocks](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/BlocksListTest.java#L22)
  - categorymembers
    - [Get first 10 pages in Category:Physics](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/CategoryMembersListTest.java#L22)
  - exturlusage
    - [Show pages linking to https://www.mediawiki.org](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/ExtUrlUsageListTest.java#L21)
  - filearchive
    - [Show a list of all deleted files](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/FileArchiveListTest.java#L20)
  - imageusage
    - [Show pages using File:Albert Einstein Head.jpg](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/ImageUsageListTest.java#L22)
  - prefixsearch
    - [Search for page titles beginning with meaning](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/PrefixSearchListTest.java#L20)
  - projects
    - [Get a list of all the projects and subprojects](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/ProjectsListTest.java#L18)
  - protectedtitles
    - [List protected titles](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/ProtectedTitlesListTest.java#L24)
  - random
    - [Return two random pages from the main namespace](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/RandomListTest.java#L23)
  - recentchanges
    - [List recent changes](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/RecentChangesListTest.java#L24)
  - tags
    - [List available tags](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/TagsListTest.java#L19)
  - usercontribs
    - [Show contributions of user Example](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/UsersContribsListTest.java#L25)
  - users
    - [Return information for user Example](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/list/UsersListTest.java#L19)

- Meta
  - globaluserinfo
    - [Get information about the current global user](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/GlobalUserInfoMetaTest.java#L23)
    - [Get information about global user Example](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/GlobalUserInfoMetaTest.java#L43)
  - languageinfo
    - [Get the language codes of all supported languages](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/LanguageInfoMetaTest.java#L22)
    - [Get the autonyms and German names of all supported languages](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/LanguageInfoMetaTest.java#L41)
    - [Get the fallback languages and variants of Occitan](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/LanguageInfoMetaTest.java#L62)
    - [Get the BCP-47 language code and direction of all supported languages](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/LanguageInfoMetaTest.java#L83)
  - siteinfo
    - [Fetch site information.](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/SiteInfoMetaTest.java#L19)
  - siteviews
    - [Show sitewide pageview totals](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/SiteViewsMetaTest.java#L20)
    - [Show sitewide unique visitor totals](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/SiteViewsMetaTest.java#L39)
  - tokens
    - [Retrieve a csrf token (the default)](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/TokensMetaTest.java#L21)
    - [Retrieve a watch token and a patrol token](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/TokensMetaTest.java#L40)
  - userinfo
    - [Get information about the current user](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/UserInfoMetaTest.java#L22)
    - [Get additional information about the current user](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/meta/UserInfoMetaTest.java#L41)

- Prop
  - categories
    - [Get a list of categories the page Albert Einstein belongs to](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/CategoriesPropTest.java#L22)
  - categoryinfo
    - [Get information about Category:Foo and Category:Bar](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/CategoryInfoPropTest.java#L20)
  - contributors
    - [Show contributors to the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/ContributorsPropTest.java#L23)
  - extlinks
    - [Get a list of external links on the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/ExtLinksPropTest.java#L21)
  - fileusage
    - [Get a list of pages using File:Example.jpg](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/FileUsagePropTest.java#L23)
  - globalusage
    - [Get usage of File:Example.jpg](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/GlobalUsagePropTest.java#L20)
  - imageinfo
    - [Fetch information about the current version of File:Albert Einstein Head.jpg](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/ImageInfoPropTest.java#L22)
    - [Fetch information about versions of File:Test.jpg from 2008 and later](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/ImageInfoPropTest.java#L42)
  - images
    - [Get a list of files used on the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/ImagesPropTest.java#L21)
  - info
    - [Get information about the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/InfoPropTest.java#L21)
  - isreviewed
    - [Determine if Main Page is marked as reviewed](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/IsReviewedPropTest.java#L19)
  - linkshere
    - [Get a list of pages linking to the Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/LinksHerePropTest.java#L21)
  - links
    - [Get links from the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/LinksPropTest.java#L21)
    - [Get links from the page Main Page in the User and Template namespaces](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/LinksPropTest.java#L41)
  - pageviews
    - [Show pageview statistics for the main page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/PageViewsPropTest.java#L19)
  - redirects
    - [Get a list of redirects to the Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/RedirectsPropTest.java#L22)
  - revisions
    - [Get data with content for the last revision of titles API and Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/RevisionsPropTest.java#L25)
    - [Get last 5 revisions of the Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/RevisionsPropTest.java#L52)
    - [Get first 5 revisions of the Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/RevisionsPropTest.java#L78)
  - templates
    - [Get the templates used on the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/TemplatesPropTest.java#L23)
    - [Get pages in the User and Template namespaces that are transcluded on the page Main Page](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/TemplatesPropTest.java#L43)
  - transcodestatus
    - [Get transcode status for File:Clip.webm](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/TranscodeStatusPropTest.java#L18)
  - videoinfo
    - [Fetch information about File:Folgers.ogv](https://github.com/MasterFlomaster1/java-wiki-api/blob/master/src/test/java/dev/masterflomaster1/jwa/request/prop/VideoInfoPropTest.java#L22)

Please refer to the [Wikipedia API Sandbox](https://en.wikipedia.org/wiki/Special:ApiSandbox) for in-depth exploration.


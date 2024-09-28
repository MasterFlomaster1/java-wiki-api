# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [v0.11.0] - 2024-09-28

### New Features:
- **Namespace and Links**:
    - Implemented support for various namespace-related features including `alllinks`, `allpages`, `allusers`, `filearchive`, `imageusage`, `protectedtitles`, `ExtUrlUsage`, `BacklinksList`, `BlocksList`, `ProjectsList`, `BetaFeatures`, `PrefixSearch`, `TagsList`, `RandomList`, and `CategoryMembersList`.
- **Links Functionality**:
    - Added implementations for `links` and `linksHere`.

### Refactoring:
- Moved enum values concatenation to a separate function.
- Replaced `Set<>` with `EnumSet<>` for better efficiency.
- Cleaned up DTO classes and removed `Format` classes.
- Updated `EnumMerger`.
- Replaced `LocalDateTime` with `Instant`.

### Tests:
- Completed URL comparison and accelerated test execution.
- Implemented direct URL comparison tests.

### Documentation:
- Updated `README.md` with the latest examples and features.
- Added a new `CHANGELOG.md` file.

### Style:
- Updated `checkstyle` rules to improve code style consistency.

### Build:
- Released version `0.11.0`.


## [0.8.1] - 2024-09-08

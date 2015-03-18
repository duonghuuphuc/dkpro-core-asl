# Recommended Practices for Commit Messages #

The following recommendations come from [Google Code](http://code.google.com/p/support/wiki/IssueTracker#Integration_with_version_control):

It is helpful if code revisions are linked with the Issue that they address.  You can easily create this link by the format of your Commit message.

As general rules of thumb:

  * The first line of the commit message should contain the issue number and issue title
  * Multiple issues should not be merged into the same commit

Following these rules make it easier for maintainers to merge changes into branches and for code reviewers to check all changes related to an issue.

A Google Code commit message can contain up to three parts:
  1. the commit notes: a summary of the revision
  1. (Newline, then) the Issue ID and any changes to the issue (update, fix/close, change of labels, etc.)
  1. a message to be posted to the Issue

## Sample Commit Messages ##

_Commit Message #1_
```
Issue 554. Organizing normalization module

Update issue 554
- Moving classes around
```

_Note: the "Update issue XXX" section causes the commit and its message to be linked to the issue in the Google issue tracker._

<a href='Hidden comment: _Commit Message #1_
```
Change the validation routines to also accept unicode string. And,
speeds up that O(N^2) comparison.

Update issue 99998
The performance and internationalization aspects of this issue have
been handled.  The remaining part of the issue has a clear work-around
and only affects a small number of users, so it is less important to fix.
```
'></a>

<a href='Hidden comment: 
_Commit Message #2_
```
Change the validation routines to also accept unicode string. And,
speeds up that O(N^2) comparison.

New issue
Summary: Update and translate end-user docs on validation
Owner: johnsmith@gmail.com
Labels: Component-Documentation
Now that we accept input in more languages, we should translate the on-line
help for that part of the application.
```

_Commit Message #3_ (Will open and close an issue all at once)

```
Bug in ngram feature extractor throws exception if stopword file is empty.

New issue
Summary: Empty stopword file throws exception
Owner: johnsmith@gmail.com
Status: Fixed
Labels: Priority-Medium
When stopword file is empty, an exception was thrown.  Instead, now, it creates an empty list.
```
'></a>

## Shortcuts to close an Issue ##

For just closing an issue (i.e., not otherwise modifying it), a "fixes" phrase can be used:

_Commit Message #2_
```
Fixes issue 553. Proplem with Clearnlp SRL
- Attach all root nodes to the virtual root, not only the first one.
```

_Note: the "Fixes issue XXX" section also causes the commit and its message to be linked to the issue in the Google issue tracker. A separate "Update issue XXX" section is not required in this case._

<a href='Hidden comment: 
_Commit Message #4_
```
Change the validation routines to also accept unicode string. And,
speeds up that O(N^2) comparison.

Fixes issue 99998
Fixes issue 99999
```

_Commit Message #5_
```
Fixes issue 998.  Change the validation routines to also accept unicode string. And,
speeds up that O(N^2) comparison.
```

_Commit Message #6_
```
(Fixes issue 998)  Change the validation routines to also accept unicode string. And,
speeds up that O(N^2) comparison.
```
'></a>
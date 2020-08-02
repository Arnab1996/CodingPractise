mkdir Arnab
cd Arnab/
ll
git init .
ls -al
cd .git
ll
cd ..
#delete the repo
rm -rf .git
echo "This is readme file" > README.MD
echo "/* THIS IS A VALID C SOURCE FILE */" > source.c
ls -al
git status
On branch master

Initial commit

Untracked files:
  (use "git add <file>..." to include in what will be committed)

        README.MD
        source.c

nothing added to commit but untracked files present (use "git add" to track
#Here you can locally change the git user and email for authentication
git add .
git status
On branch master

Initial commit

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

        new file:   README.MD
        new file:   source.c

git commit -m "Tis is the initial commit of files to our repo"
[master (root-commit) fc0dc17] Tis is the initial commit of files to our repo
 2 files changed, 2 insertions(+)
 create mode 100644 README.MD
 create mode 100644 source.c
git status
On branch master
nothing to commit, working tree clean
vi README.MD
#Make some changes
git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   README.MD

no changes added to commit (use "git add" and/or "git commit -a")
git commit -a
[master 7d2c856] Saving the changes in the README.md
 1 file changed, 2 insertions(+)
git add .
git status
mkdir newFolder
mkdir newFolder2
echo "test" > newFolder/new.txt
echo "test1" > newFolder2/new.txt
git add .
git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        new file:   newFolder/new.txt
        new file:   newFolder2/new.txt

git commit -m "Added new source directories"
git rm -rf newFolder
git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        deleted:    newFolder/new.txt
git commit -m "Removed a folder newFolder"
[master 265d1ba] Removed a folder newFolder
 1 file changed, 1 deletion(-)
 delete mode 100644 newFolder/new.txt
 
 
git log
commit 265d1ba439fc55680feb411871296961737acf16 (HEAD -> master)
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:11:45 2018 +0300

    Removed a folder newFolder

commit 75b3d209ee414decb52cdd633a6d448f228d0a89
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:08:21 2018 +0300

    Added new source directories

commit 7d2c856fb797ce124cccf300b9c313e19c117972
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:28:27 2018 +0300

    Saving the changes in the README.md

commit fc0dc17fca39f701c4518c2189a482b08b96c120
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:24:48 2018 +0300

    Tis is the initial commit of files to our repo

git log --oneline
265d1ba (HEAD -> master) Removed a folder newFolder
75b3d20 Added new source directories
7d2c856 Saving the changes in the README.md
fc0dc17 Tis is the initial commit of files to our repo
	
git log -p
commit 265d1ba439fc55680feb411871296961737acf16 (HEAD -> master)
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:11:45 2018 +0300

    Removed a folder newFolder

diff --git a/newFolder/new.txt b/newFolder/new.txt
deleted file mode 100644
index a5bce3f..0000000
--- a/newFolder/new.txt
+++ /dev/null
@@ -1 +0,0 @@
-test1

commit 75b3d209ee414decb52cdd633a6d448f228d0a89
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:08:21 2018 +0300

    Added new source directories

diff --git a/newFolder/new.txt b/newFolder/new.txt
new file mode 100644
index 0000000..a5bce3f
--- /dev/null
+++ b/newFolder/new.txt
@@ -0,0 +1 @@
+test1
diff --git a/newFolder2/new.txt b/newFolder2/new.txt
new file mode 100644
index 0000000..a5bce3f
--- /dev/null
+++ b/newFolder2/new.txt
@@ -0,0 +1 @@
+test1

commit 7d2c856fb797ce124cccf300b9c313e19c117972
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:28:27 2018 +0300

    Saving the changes in the README.md

diff --git a/README.MD b/README.MD
index 143e827..4d0ab86 100644
--- a/README.MD
+++ b/README.MD
@@ -1 +1,3 @@
 This is readme file
+
+This is the initial commit.

commit fc0dc17fca39f701c4518c2189a482b08b96c120
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:24:48 2018 +0300

    Tis is the initial commit of files to our repo

diff --git a/README.MD b/README.MD
new file mode 100644
index 0000000..143e827
--- /dev/null
+++ b/README.MD
@@ -0,0 +1 @@
+This is readme file
diff --git a/source.c b/source.c
new file mode 100644
index 0000000..babf005
--- /dev/null
+++ b/source.c
@@ -0,0 +1 @@
+/* THIS IS A VALID C SOURCE FILE */

git log -- newFolder2
commit 75b3d209ee414decb52cdd633a6d448f228d0a89
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:08:21 2018 +0300

    Added new source directories
	
git log --oneline -- newFolder2
75b3d20 Added new source directories

git log --author="Karthick Dudyala"
commit 265d1ba439fc55680feb411871296961737acf16 (HEAD -> master)
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:11:45 2018 +0300

    Removed a folder newFolder

commit 75b3d209ee414decb52cdd633a6d448f228d0a89
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 09:08:21 2018 +0300

    Added new source directories

commit 7d2c856fb797ce124cccf300b9c313e19c117972
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:28:27 2018 +0300

    Saving the changes in the README.md

commit fc0dc17fca39f701c4518c2189a482b08b96c120
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:24:48 2018 +0300

    Tis is the initial commit of files to our repo
	
git log --grep="change"
commit 7d2c856fb797ce124cccf300b9c313e19c117972
Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
Date:   Tue Sep 18 08:28:27 2018 +0300

    Saving the changes in the README.md

git log --graph
* commit 265d1ba439fc55680feb411871296961737acf16 (HEAD -> master)
| Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
| Date:   Tue Sep 18 09:11:45 2018 +0300
|
|     Removed a folder newFolder
|
* commit 75b3d209ee414decb52cdd633a6d448f228d0a89
| Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
| Date:   Tue Sep 18 09:08:21 2018 +0300
|
|     Added new source directories
|
* commit 7d2c856fb797ce124cccf300b9c313e19c117972
| Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
| Date:   Tue Sep 18 08:28:27 2018 +0300
|
|     Saving the changes in the README.md
|
* commit fc0dc17fca39f701c4518c2189a482b08b96c120
  Author: Karthick Dudyala <karthick.dudyala@amdocs.com>
  Date:   Tue Sep 18 08:24:48 2018 +0300

      Tis is the initial commit of files to our repo
	
man git log	

cd ..
mkdir workingDir/	
cd workingDir/	
git clone ../Arnab .	
ls -al	
vi source.c
#Make some non erroruos changes
git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   source.c

no changes added to commit (use "git add" and/or "git commit -a")

#Change and specify user and email here Or else it shows Who You are??
git add .
git commit -m "Modified local copy"
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
        modified:   source.c

no changes added to commit

Git global setup
git config --global user.name "Arnab Saha"
git config --global user.email "arnab.saha@amdocs.com"

Create a new repository
git clone git@gitlab.corp.amdocs.com:arnabsa/CryptoLab.git
cd CryptoLab
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master

Existing folder
cd existing_folder
git init
git remote add origin git@gitlab.corp.amdocs.com:arnabsa/CryptoLab.git
git add .
git commit -m "Initial commit"
git push -u origin master

Existing Git repository
cd existing_repo
git remote rename origin old-origin
git remote add origin git@gitlab.corp.amdocs.com:arnabsa/CryptoLab.git
git push -u origin --all
git push -u origin --tags

git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")

git add .
ll
/users/admin/github/CryptoLab
total 100
-rw-r--r--. 1 admin aimsys  845 Sep 18 10:06 Caesar_Cipher.cpp
-rw-r--r--. 1 admin aimsys 1482 Sep 18 10:06 Affine_Cipher.cpp
-rw-r--r--. 1 admin aimsys  588 Sep 18 10:06 Affine_Attack.cpp
-rw-r--r--. 1 admin aimsys 8514 Sep 18 10:06 AES.cpp
-rw-r--r--. 1 admin aimsys  847 Sep 18 10:06 Additive_Cipher.cpp
-rw-r--r--. 1 admin aimsys  870 Sep 18 10:06 P_RSAcommon-modulus.cpp
-rw-r--r--. 1 admin aimsys  384 Sep 18 10:06 P_RSA-chosen-ciphertext.cpp
-rw-r--r--. 1 admin aimsys 1477 Sep 18 10:06 Multiplicative_Cipher.cpp
-rw-r--r--. 1 admin aimsys  603 Sep 18 10:06 Mult_Inv.cpp
-rw-r--r--. 1 admin aimsys 3294 Sep 18 10:06 MD5.cpp
-rw-r--r--. 1 admin aimsys 1039 Sep 18 10:06 Knapsack_Crypto.cpp
-rw-r--r--. 1 admin aimsys 2943 Sep 18 10:06 IDEA_Modified.cpp
-rw-r--r--. 1 admin aimsys 2221 Sep 18 10:06 IDEA.cpp
-rw-r--r--. 1 admin aimsys  466 Sep 18 10:06 Elgamal.cpp
-rw-r--r--. 1 admin aimsys  843 Sep 18 10:06 Difie_MITM.cpp
-rw-r--r--. 1 admin aimsys 1480 Sep 18 10:06 DES.cpp
-rw-r--r--. 1 admin aimsys 1258 Sep 18 10:06 Chinese_Remainder_Theorem.cpp
-rw-r--r--. 1 admin aimsys 1953 Sep 18 10:06 RSA.cpp
-rw-r--r--. 1 admin aimsys  320 Sep 18 10:06 RSA_Attack.cpp
-rw-r--r--. 1 admin aimsys 1047 Sep 18 10:06 RC4.cpp
-rw-r--r--. 1 admin aimsys 1133 Sep 18 10:06 elliptic.cpp
-rw-r--r--. 1 admin aimsys  716 Sep 18 10:06 diffie_hellma.cpp
-rw-r--r--. 1 admin aimsys  113 Sep 18 10:10 README.md
drwxr-xr-x. 8 admin aimsys  163 Sep 18 10:10 .git
git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        modified:   README.md
		
git config user.name "Arnab1996"
git config user.email "arnabofficial1996@outlook.com"
clear
git commit -m "Updated README.md"
[master 246ceb8] Updated README.md
 1 file changed, 2 insertions(+)
git status
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)
nothing to commit, working tree clean

git push origin master
Username for 'https://github.com': Arnab1996
Password for 'https://Arnab1996@github.com':
Counting objects: 3, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 325 bytes | 0 bytes/s, done.
Total 3 (delta 2), reused 0 (delta 0)
remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
To https://github.com/Arnab1996/CryptoLab.git
   69d7454..246ceb8  master -> master

#Always remember to delete the .git folder

git config --global core.excludesfile

vi .gitignore
cp source.c source.bak
git add .
git commit -m "adding the gitignore file"
	
git branch
* master

git branch dev
git branch
  dev
* master
git checkout dev
Switched to branch 'dev'
git branch
* dev
  master
#This also can be used
git checkout -b dev

git push origin dev
Username for 'https://github.com': Arnab1996
Password for 'https://Arnab1996@github.com':


	
	
	
	
	
	
	
	
	
	
	


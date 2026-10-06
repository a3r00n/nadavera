$sourceDir = "src"
$outputDir = "out"

$javaFiles = Get-ChildItem -Path $sourceDir -Recurse -Filter "*.java"

javac -d $outputDir $javaFiles.FullName

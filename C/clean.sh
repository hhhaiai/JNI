#!/usr/bin/env bash


clean_task() {
    filename=$(basename $0)
    echo "[$filename]>>>>clean project<<<<"
    dir=("jniC" )
    for element in "${dir[@]}"; do
        #clean task
        rm -rf $element/build/
        rm -rf $element/bin/
        rm -rf $element/gen/
        rm -rf $element/.externalNativeBuild
        rm -rf $element/.DS_Store
        rm -rf $element/__MACOSX
        rm -rf $element/.cxx
        echo "[$filename]clean $element over."
    done

    rm -rf build/
    rm -rf release/
    rm -rf releasebak/
    rm -rf sh.exe.stackdump
    rm -rf classes.dex
    rm -rf .vs/
    rm -rf .vscode/
    rm -rf .DS_Store
    rm -rf __MACOSX

  if [ $# == 0 ]; then
    echo "[$filename]clean project success. "
  else
    echo "[$filename]clean project Failed!"
  fi

}

main() {

  clean_task
}

main

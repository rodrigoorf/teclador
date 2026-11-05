# Teclador

Teclador is a joke Android keyboard: it appends an **R** to the end of every word, always before punctuation.

Examples:

| You type | Teclador writes |
| --- | --- |
| `house` + space | `houser ` |
| `house.` | `houser.` |
| `falar` | `falarr` |
| `CASA` | `CASAR` |
| `Casa` | `Casar` |

The project is a fork of [HeliBoard](https://github.com/HeliBorg/HeliBoard), a privacy-conscious, offline, open-source keyboard based on AOSP/OpenBoard.

> **Disclaimer:** this app is a joke. It is not affiliated with HeliBoard or OpenBoard.

## How it works

- The R is inserted when the word is committed, so it works for typed words, auto-corrections, and manually picked suggestions.
- If the word already ends in R, another R is appended: `falar` → `falarr`.
- All-uppercase words get an uppercase `R`; everything else gets a lowercase `r`.
- Backspace deletes normally; the R is not treated as a revertible auto-correction.
- Dictionary and history learning still use the original word, without the R.
- The feature is automatically disabled in sensitive fields: passwords, e-mail, URLs, numbers, and similar.

## Settings

The R feature is **enabled by default** for normal prose fields.

To turn it on or off:

1. Open the Teclador settings.
2. Go to **Text correction → Corrections**.
3. Toggle **“Add R to every word (joke)”**.

## Installation

Download the latest APK from the [releases](../../releases) page or build it locally.

Build requirements:

- JDK 21
- Android SDK 37
- Android NDK 28.0.13004108
- Android SDK Build-Tools 37.0.0

```bash
export JAVA_HOME=/path/to/jdk-21
export ANDROID_HOME=/path/to/android-sdk

./gradlew :app:assembleDebug
```

The APK is generated at:

```
app/build/outputs/apk/debug/Teclador_<version>-debug.apk
```

To install it on a connected device:

```bash
adb install -r app/build/outputs/apk/debug/Teclador_*-debug.apk
```

Then enable **Teclador** in *Settings → System → Keyboards → Manage keyboards*.

## Tests

```bash
./gradlew :app:testDebugUnitTest \
  --tests 'helium314.keyboard.latin.utils.REndingTest' \
  --tests 'helium314.keyboard.latin.InputLogicTest.appendR*'
```

The full suite contains a few tests that are known to fail in the `debug` build (they are skipped in the `runTests` build), plus tests that check external links.

## License

This project is distributed under the **GNU General Public License v3.0**, the same license as HeliBoard. See [LICENSE](LICENSE).

Because HeliBoard is based on the Apache 2.0 licensed AOSP keyboard, the [LICENSE-Apache-2.0](LICENSE-Apache-2.0) file is also kept. The icon is licensed under [Creative Commons BY-SA 4.0](LICENSE-CC-BY-SA-4.0).

## Credits

All credit for the original keyboard goes to the HeliBoard project and its contributors:

- [HeliBoard](https://github.com/HeliBorg/HeliBoard)
- [OpenBoard](https://github.com/openboard-team/openboard)
- [AOSP Keyboard](https://android.googlesource.com/platform/packages/inputmethods/LatinIME/)
- [LineageOS](https://review.lineageos.org/admin/repos/LineageOS/android_packages_inputmethods_LatinIME)
- [Simple Keyboard](https://github.com/rkkr/simple-keyboard)
- [Indic Keyboard](https://gitlab.com/indicproject/indic-keyboard)
- [FlorisBoard](https://github.com/florisboard/florisboard/)
- [HeliBoard contributors](https://github.com/HeliBorg/HeliBoard/graphs/contributors)
- Icon by [Fabian OvrWrt](https://github.com/FabianOvrWrt), with contributions from [The Eclectic Dyslexic](https://github.com/the-eclectic-dyslexic)

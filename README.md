# Teclador

Teclador é um teclado Android de brincadeira: ele adiciona um **R** ao final de cada palavra, sempre antes da pontuação.

Exemplos:

| Você digita | O Teclador escreve |
| --- | --- |
| `casa` + espaço | `casar ` |
| `casa.` | `casar.` |
| `falar` | `falarr` |
| `CASA` | `CASAR` |
| `Casa` | `Casar` |

O projeto é um fork do [HeliBoard](https://github.com/HeliBorg/HeliBoard), um teclado open-source, privado e offline baseado no AOSP/OpenBoard.

> **Aviso:** este app é uma piada. Não é afiliado ao HeliBoard nem ao OpenBoard.

## Como funciona

- O R é inserido no momento em que a palavra é confirmada, então funciona com palavras digitadas, auto-correção e sugestões escolhidas manualmente.
- Se a palavra já termina em R, entra outro R: `falar` → `falarr`.
- Palavras totalmente em maiúsculas recebem `R`; as demais recebem `r`.
- O backspace apaga normalmente; o R não é tratado como uma auto-correção reversível.
- O dicionário e o histórico continuam aprendendo a palavra original, sem o R.
- O recurso é desativado automaticamente em campos sensíveis: senha, e-mail, URL, números e afins.

## Configuração

O R vem **ativado por padrão** em campos de texto normais.

Para ligar ou desligar:

1. Abra as configurações do Teclador.
2. Vá em **Correção de texto → Correções**.
3. Alterne **“Adicionar R no final das palavras (brincadeira)”**.

## Instalação

Baixe o APK mais recente nas [releases](../../releases) ou compile localmente.

Requisitos para compilar:

- JDK 21
- Android SDK 37
- Android NDK 28.0.13004108
- Android SDK Build-Tools 37.0.0

```bash
export JAVA_HOME=/caminho/para/jdk-21
export ANDROID_HOME=/caminho/para/android-sdk

./gradlew :app:assembleDebug
```

O APK será gerado em:

```
app/build/outputs/apk/debug/Teclador_<versão>-debug.apk
```

Para instalar em um dispositivo conectado:

```bash
adb install -r app/build/outputs/apk/debug/Teclador_*-debug.apk
```

Depois ative o **Teclador** em *Configurações → Sistema → Teclados → Gerenciar teclados*.

## Testes

```bash
./gradlew :app:testDebugUnitTest \
  --tests 'helium314.keyboard.latin.utils.REndingTest' \
  --tests 'helium314.keyboard.latin.InputLogicTest.appendR*'
```

A suíte completa contém alguns testes conhecidos que falham no build `debug` (eles são pulados no build `runTests`), além de testes de links externos.

## Licença

Este projeto é distribuído sob a **GNU General Public License v3.0**, a mesma licença do HeliBoard. Veja [LICENSE](LICENSE).

Como o HeliBoard é baseado no teclado AOSP (Apache 2.0), o arquivo [LICENSE-Apache-2.0](LICENSE-Apache-2.0) também é mantido. O ícone usa [Creative Commons BY-SA 4.0](LICENSE-CC-BY-SA-4.0).

## Créditos

Todo o mérito do teclado original é do projeto HeliBoard e de seus contribuidores:

- [HeliBoard](https://github.com/HeliBorg/HeliBoard)
- [OpenBoard](https://github.com/openboard-team/openboard)
- [AOSP Keyboard](https://android.googlesource.com/platform/packages/inputmethods/LatinIME/)
- [LineageOS](https://review.lineageos.org/admin/repos/LineageOS/android_packages_inputmethods_LatinIME)
- [Simple Keyboard](https://github.com/rkkr/simple-keyboard)
- [Indic Keyboard](https://gitlab.com/indicproject/indic-keyboard)
- [FlorisBoard](https://github.com/florisboard/florisboard/)
- Os [contribuidores do HeliBoard](https://github.com/HeliBorg/HeliBoard/graphs/contributors)
- Ícone por [Fabian OvrWrt](https://github.com/FabianOvrWrt), com contribuições de [The Eclectic Dyslexic](https://github.com/the-eclectic-dyslexic)

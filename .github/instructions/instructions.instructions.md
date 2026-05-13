---
description: "Use when working on this repository (Groovy + Gradle + Spring Boot + QA automation): enforce Java 21, Screenplay conventions, and SRP in Tasks."
applyTo: "**/*.{groovy,java,gradle,feature,properties,md,txt}"
---

## Project Context

This repository is a technical QA exercise focused on automated E2E testing of the purchase flow at https://www.demoblaze.com/.

Current technical base:
- Build system: Gradle wrapper (`gradlew`, `gradlew.bat`)
- Language: Groovy (with Java 21 toolchain)
- Main package base: `com.example.demo`
- Testing platform target: Serenity BDD with Screenplay pattern (for the exercise scope)

## Coding Guidelines

1. Keep Java 21 compatibility
- Do not downgrade toolchain version.
- Keep Gradle configuration aligned with Java 21.

2. Prefer Groovy in existing source sets
- Follow `src/main/groovy` and `src/test/groovy` when adding application or test code.
- Keep package naming consistent with `com.example.demo` unless the user asks to change it.

3. Respect Screenplay architecture for QA automation code
- Separate concerns into clear roles (for example: Page objects/UI maps, Tasks, Interactions, Questions, Step Definitions, Runner, Hooks, Utils).
- Enforce single responsibility in each Task class.
- Keep selectors centralized per page/screen object; avoid scattering locators in step definitions.

4. Test design rules
- Prefer deterministic assertions and explicit waits over fixed sleeps.
- Cover the required E2E flow: add two products, open cart, complete purchase form, finish purchase.
- Keep scenarios readable in Gherkin and map each step to reusable automation code.

5. Change safety
- Preserve existing behavior unless the user explicitly asks for refactoring.
- Avoid introducing unrelated frameworks or libraries.
- Make focused changes; do not reformat unrelated files.

## Validation Checklist

Before finishing implementation tasks, run relevant checks:
- Windows: `./gradlew.bat test`
- Cross-platform shell: `./gradlew test`

If E2E tasks are added, also verify:
- Feature files and step definitions stay synchronized.
- Runner and hooks are correctly wired.

## Response Guidelines For The Agent

When answering questions or proposing code:
- Prioritize practical steps and runnable changes in this repository.
- Mention concrete file paths to edit.
- For reviews, prioritize defects, regressions, and missing validations first.
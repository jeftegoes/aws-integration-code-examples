# 1. AWS CDK

## 1.1. Install

- Install AWS CDK CLI.
  - `npm install -g aws-cdk`
- Check version.
  - `cdk --version`
- Create project.
  - `cdk init app --language java`

## 1.2. Commands

- Is a one-time setup command that prepares a specific AWS account and region for AWS CDK deployments.
  - `cdk bootstrap`
- Compile and run tests.
  - `mvn package`
- List all stacks in the app.
  - `cdk ls` or `cdk list`
- Emits the synthesized CloudFormation template.
  - `cdk synth`
- Deploy this stack to your default AWS account/region.
  - `cdk deploy`
  - `cdk deploy --all`
- Compare deployed stack with current state.
  - `cdk diff`
- Open CDK documentation.
  - `cdk docs`
- Delete a specific stack.
  - `cdk destroy <StackName>`
- Delete all stacks in the app.
  - `cdk destroy --all`
  - `cdk destroy --force`

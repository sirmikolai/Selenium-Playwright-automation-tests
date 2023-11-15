#!/bin/bash
set -ex
wget https://packages.microsoft.com/repos/edge/pool/main/m/microsoft-edge-beta/microsoft-edge-beta_113.0.1774.27-1_amd64.deb
sudo apt install ./microsoft-edge-beta_113.0.1774.27-1_amd64.deb
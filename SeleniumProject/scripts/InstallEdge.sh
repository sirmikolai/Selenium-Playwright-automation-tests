#!/bin/bash
set -ex
wget https://packages.microsoft.com/repos/edge/pool/main/m/microsoft-edge-stable/microsoft-edge-stable_119.0.2151.58-1_amd64.deb
sudo apt install ./microsoft-edge-stable_119.0.2151.58-1_amd64.deb

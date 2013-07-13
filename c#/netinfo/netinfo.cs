using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Net;
using System.Net.Sockets;
using System.DirectoryServices;

namespace ipcheck
{
    //private System.ComponentModel.Container components = null;
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }
        [DllImport("Iphlpapi.dll")]
        private static extern int SendARP(Int32 dest, Int32 host, ref Int64 mac, ref Int32 length);
        [DllImport("Ws2_32.dll")]
        private static extern Int32 inet_addr(string ip);
        private string macAddress, ipAddress;

        private bool canPing = false;
        private string GetMacAddress() // 得到指定IP的MAC地址 
        {
            Int32 ldest = 0;
            try
            {
                ldest = inet_addr(ipAddress);
            }
            catch (Exception iperr)
            {
                MessageBox.Show(iperr.Message);
            }
            Int64 macinfo = new Int64();
            Int32 len = 6;
            try
            {
                int res = SendARP(ldest, 0, ref macinfo, ref len);
            }
            catch (Exception err)
            {
                //    throw new Exception("在解析MAC地址过程发生了错误!"); 
                MessageBox.Show(err.Message);
            }
            string originalMACAddress = macinfo.ToString("X4");
            if (originalMACAddress != "0000" && originalMACAddress.Length == 12)
            { //合法MAC地址 
                string mac1, mac2, mac3, mac4, mac5, mac6;
                mac1 = originalMACAddress.Substring(10, 2);
                mac2 = originalMACAddress.Substring(8, 2);
                mac3 = originalMACAddress.Substring(6, 2);
                mac4 = originalMACAddress.Substring(4, 2);
                mac5 = originalMACAddress.Substring(2, 2);
                mac6 = originalMACAddress.Substring(0, 2);
                macAddress = mac1 + "-" + mac2 + "-" + mac3 + "-" + mac4 + "-" + mac5 + "-" + mac6;
                canPing = true;
            }
            else
            {
                macAddress = "无法探测到MAC地址";
                canPing = false;
            }
            return macAddress;
        }

        private void tbar_ButtonClick(object sender, ToolBarButtonClickEventArgs e)
        {
            switch (e.Button.Name)
            {
                case "Btn_search":
                    int i = 0;
                    DirectoryEntry root = new DirectoryEntry("WinNT:");
                    DirectoryEntries domains = root.Children;
                    domains.SchemaFilter.Add("domain");
                    foreach (DirectoryEntry domain in domains)
                    {
                        this.g_list.Items.Add(domain.Name.ToString());

                        DirectoryEntries computers = domain.Children;
                        computers.SchemaFilter.Add("computer");
                        foreach (DirectoryEntry computer in computers)
                        {
                            this.Grid_view.Rows.Add();
                            this.Grid_view.Rows[i].Cells[0].Value = i + 1;
                            this.Grid_view.Rows[i].Cells[1].Value = computer.Name.ToString();
                            IPHostEntry iphe = null;
                            try
                            {
                                iphe = Dns.GetHostByName(computer.Name.ToString());
                                this.Grid_view.Rows[i].Cells[2].Value = iphe.AddressList[0].ToString();
                                ipAddress = iphe.AddressList[0].ToString();
                                this.Grid_view.Rows[i].Cells[3].Value = getmacaddress();
                            }
                            catch (Exception e)
                            {
                                continue;
                            }
                            this.grid_view.rows[i].cells[4].value = domain.name.tostring();
                            i++;
                        }

                    }
                    break;
            }
        }
    }
}
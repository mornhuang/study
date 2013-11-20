#include <QApplication>
#include <QTreeView>
#include <QDebug>
#include <QStandardItemModel>
#include <QFileSystemModel>
#include <QListView>

int main(int argc, char* argv[])
{
    QApplication app(argc, argv);

    // example 1
    QStandardItemModel model;
    QStandardItem *parentItem = model.invisibleRootItem();

    QStandardItem *item0 = new QStandardItem;
    item0->setText("A");
    QPixmap pixmap0(50, 50);
    pixmap0.fill("red");
    item0->setIcon(QIcon(pixmap0));
    item0->setToolTip("indexA");
    parentItem->appendRow(item0);
    parentItem = item0;

    QStandardItem *item1 = new QStandardItem;
    item1->setText("B");
    QPixmap pixmap1(50, 50);
    pixmap1.fill("blue");
    item1->setIcon(QIcon(pixmap1));
    item1->setToolTip("indexB");
    parentItem->appendRow(item1);

    QStandardItem *item2 = new QStandardItem;
    QPixmap pixmap2(50, 50);
    pixmap2.fill("green");
    item2->setData("C", Qt::DisplayRole);
    item2->setData("indexC", Qt::ToolTipRole);
    item2->setData(QIcon(pixmap2), Qt::DecorationRole);
    QList<QStandardItem*> list;
    list.append(item2);
    list.append(item2);
    parentItem->appendRow(list);

    QTreeView view;
    view.setModel(&model);
    view.show();

    QModelIndex indexA = model.index(0, 0, QModelIndex());
    qDebug() << "indexA row count" << model.rowCount(indexA) << endl;
    QModelIndex indexB = model.index(0, 0, indexA);
    qDebug() << "indexB text" << model.data(indexB, Qt::EditRole).toString() << endl;
    qDebug() << "indexB tooltips" << model.data(indexB, Qt::ToolTipRole).toString() << endl;

    // example2
    QFileSystemModel model2;
    model2.setRootPath(QDir::currentPath());

    QTreeView view2;
    view2.setModel(&model2);
    view2.setRootIndex(model2.index(QDir::currentPath()));
    view2.show();

    QListView view3;
    view3.setModel(&model2);
    view3.setRootIndex(model2.index(QDir::currentPath()));
    view3.show();


    return app.exec();
}
